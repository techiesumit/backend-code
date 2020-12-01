package com.sumit.interview.solution.employeevacation.controller;

import com.sumit.interview.solution.employeevacation.entity.Employee;
import com.sumit.interview.solution.employeevacation.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@Slf4j
public class VacationController {
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeServiceImpl.getEmployee(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployees() {
        log.info("getEmployees");
        List<Employee> allEmployees = employeeServiceImpl.getEmployees();
        return new ResponseEntity<List<Employee>>(allEmployees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{employee_id}/{vacationDays}/{workDays}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateVacationAndWorkDays(@PathVariable Long employee_id, @PathVariable Float vacationDays, @PathVariable Float workDays) {
        employeeServiceImpl.updateVacationAndWorkDays(employee_id, vacationDays, workDays);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{workDays}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateWorkDaysforEmployee(@PathVariable Float workDays) {
        employeeServiceImpl.updateWorkDays(workDays);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{vacationDays}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateVacationDaysforEmployee(@PathVariable Float vacationDays) {
        employeeServiceImpl.updateVacationDays(vacationDays);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
