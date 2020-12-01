package com.sumit.interview.solution.employeevacation.service;

import com.sumit.interview.solution.employeevacation.entity.Employee;

import java.util.List;

public interface EmployeeHardCodedDataService {
    List<Employee> findAll();
    void updateWorkDays(Float workdays);
    void updateVacationDays(Float vacations);
    Employee findById(Long id);
    void updateVacationAndWorkDays(Long id, Float vacations, Float workdays);
}
