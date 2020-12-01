package com.sumit.interview.solution.employeevacation.service;

import com.sumit.interview.solution.employeevacation.entity.Employee;
import com.sumit.interview.solution.employeevacation.utils.EmployeeType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalariedEmployeeManagerHardCodedDataServiceImpl implements EmployeeHardCodedDataService {
    private static List<Employee> salariedEmployeesManagerData = new ArrayList<>();
    private static Long idCounter = 20L;

    static {
        for (int ctr = 0; ctr < 10; ctr++) {
            salariedEmployeesManagerData.add(new Employee(++idCounter, EmployeeType.MANAGER, 0.00F, 0.00F,""));
        }
    }


    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public void updateWorkDays(Float workdays) {

    }

    @Override
    public void updateVacationDays(Float vacations) {

    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public void updateVacationAndWorkDays(Long id, Float vacations, Float workdays) {

    }
}
