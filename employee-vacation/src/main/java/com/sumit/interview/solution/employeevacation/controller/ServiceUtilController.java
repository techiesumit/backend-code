package com.sumit.interview.solution.employeevacation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class ServiceUtilController {
    @RequestMapping(method = RequestMethod.GET, path = "/healthcheck")
    public ResponseEntity<String> pingService() {
        return new ResponseEntity<String>("Server is Alive", HttpStatus.OK);
    }
}
