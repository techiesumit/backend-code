package com.sumit.interview.solution.employeevacation.service;

import com.sumit.interview.solution.employeevacation.entity.Employee;
import com.sumit.interview.solution.employeevacation.utils.EmployeeType;
import com.sumit.interview.solution.employeevacation.utils.EmployeeVacationConstants;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeHardCodedDataServiceImpl implements EmployeeHardCodedDataService {
    private static List<Employee> hourlyEmployeesData = new ArrayList<>();
    private static List<Employee> salariedEmployeesData = new ArrayList<>();
    private static List<Employee> salariedEmployeesManagerData = new ArrayList<>();
    private static List<Employee> allEmployeeData = new ArrayList<>();
    private static Long idCounter = 0L;


    static {
        for (int ctr = 0; ctr < 10; ctr++) {
            hourlyEmployeesData.add(new Employee(++idCounter, EmployeeType.HOURLY, 0F, 0F,""));
        }
        for (int ctr = 0; ctr < 10; ctr++) {
            salariedEmployeesData.add(new Employee(++idCounter, EmployeeType.SALARIED, 0F, 0F,""));
        }
        for (int ctr = 0; ctr < 10; ctr++) {
            salariedEmployeesManagerData.add(new Employee(++idCounter, EmployeeType.MANAGER, 0F, 0F,""));
        }
        List<List<Employee>> listOfAllEmployees = new ArrayList<>();
        // Add all them to the list
        listOfAllEmployees.add(hourlyEmployeesData);
        listOfAllEmployees.add(salariedEmployeesManagerData);
        listOfAllEmployees.add(salariedEmployeesData);
        allEmployeeData = listOfAllEmployees.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public List<Employee> findAll() {
        return allEmployeeData;
    }
    @Override
    public Employee findById(Long employee_id) {
        return allEmployeeData.stream()
                .filter(emp -> employee_id == emp.getEmployee_id()).findFirst().orElse(null);
    }

   @Override
    public void updateWorkDays(Float workdays) {
        allEmployeeData.stream().forEach(
                emp -> validateAndUpdateWorkday(emp, workdays)
        );
    }


    @Override
    public void updateVacationDays(Float vacations) {
        allEmployeeData.stream().forEach(
                emp -> validateAndUpdateWorkday(emp, vacations)
        );
    }

    @Override
    public void updateVacationAndWorkDays(Long id, Float vacations, Float workdays) {
        Employee emp = findById(id);
        validateAndUpdateWorkday(emp, workdays);
        validateAndUpdateVacationDays(emp, vacations);
    }
    private void validateAndUpdateWorkday(Employee emp, Float workdays) {
        Float workDaysUpdated= (emp.getWorkDays() + workdays);
        if (workDaysUpdated > EmployeeVacationConstants.WORK_DAYS_IN_YEAR ) {
            emp.setErrorMessage(EmployeeVacationConstants.WORK_DAYS_OVER);
        } else {
            emp.setWorkDays(workDaysUpdated);
            emp.setErrorMessage("");
        }
    }

    private void validateAndUpdateVacationDays(Employee emp, Float vacationDays) {
        Float vacations = emp.getVacationDays() + vacationDays;
        if (emp.getEmployee_type().equals(EmployeeType.HOURLY)) {
            if (vacations > EmployeeVacationConstants.HOURLY_EMP_VACATION) {
                emp.setErrorMessage(EmployeeVacationConstants.VACATION_DAYS_OVER );
            } else {
                emp.setVacationDays(vacations);
                emp.setErrorMessage("");
            }
        }
        if (emp.getEmployee_type().equals(EmployeeType.SALARIED)) {
            if (vacations > EmployeeVacationConstants.SALARIED_EMP_VACATION) {
                emp.setErrorMessage(EmployeeVacationConstants.VACATION_DAYS_OVER );
            } else {
                emp.setVacationDays(vacations);
            }
        }
        if (emp.getEmployee_type().equals(EmployeeType.MANAGER)) {
            if (vacations > EmployeeVacationConstants.MANAGER_EMP_VACATION) {
                emp.setErrorMessage(EmployeeVacationConstants.VACATION_DAYS_OVER);
            } else {
                emp.setVacationDays(vacations);
            }
        }
    }


}
