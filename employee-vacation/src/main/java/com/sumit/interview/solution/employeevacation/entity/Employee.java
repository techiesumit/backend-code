package com.sumit.interview.solution.employeevacation.entity;

import com.sumit.interview.solution.employeevacation.utils.EmployeeType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Employee {
    private Long employee_id;
    private EmployeeType employee_type;
    private Float workDays;
    private Float vacationDays;
    // Adding any Invalid Data Error as part of this Entity, but as per design it should be separate entity responsible for Error as per SRP
    private String errorMessage;


}
