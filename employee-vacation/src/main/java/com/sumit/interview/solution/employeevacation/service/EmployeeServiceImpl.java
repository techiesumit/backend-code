package com.sumit.interview.solution.employeevacation.service;

import com.sumit.interview.solution.employeevacation.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeHardCodedDataServiceImpl employeeHardCodedDataService;

    /*private SalariedEmployeeHardCodedDataServiceImpl salariedEmployeeHardCodedDataService;
    private SalariedEmployeeManagerHardCodedDataServiceImpl salariedEmployeeManagerHardCodedDataService;*/
    @Autowired
    public EmployeeServiceImpl(EmployeeHardCodedDataServiceImpl employeeHardCodedDataService) {
        this.employeeHardCodedDataService = employeeHardCodedDataService;
    }

    @Override
    public Employee getEmployee(Long employee_id) {

        return employeeHardCodedDataService.findById(employee_id);
    }

    @Override
    public void updateWorkDays(Float workdays) {

        employeeHardCodedDataService.updateWorkDays(workdays);
    }

    @Override
    public void updateVacationDays(Float vacations) {
        employeeHardCodedDataService.updateVacationDays(vacations);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeHardCodedDataService.findAll();
    }

    @Override
    public void updateVacationAndWorkDays(Long employee_id, Float vacations, Float workDays) {
        employeeHardCodedDataService.updateVacationAndWorkDays(employee_id, vacations, workDays);
    }


}
