package com.sumit.interview.solution.employeevacation.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumit.interview.solution.employeevacation.entity.Employee;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class DataReaderUtil {

    public static List<Employee> readData(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream(fileName);
        try {
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            log.error("Cannot Read the Data File");
        }
        return null;
    }
}
