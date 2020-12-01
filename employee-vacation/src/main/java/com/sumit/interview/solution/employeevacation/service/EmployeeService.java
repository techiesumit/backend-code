package com.sumit.interview.solution.employeevacation.service;

import com.sumit.interview.solution.employeevacation.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // Get a single Employee
    Employee getEmployee(Long employee_id);

    // Add the WorkDays to the Employee Records
    void updateWorkDays(Float workdays);

    // Add the Vacation Days to the Employees
    void updateVacationDays(Float vacations);

    // Get all the employees
    List<Employee> getEmployees();

    // Update record for an Employee with vacation Days and WorkDays (Single Record)
    void updateVacationAndWorkDays(Long employee_id, Float vacations, Float workDays);
}
