package com.example.fulldemo;


public class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(long id) {
        super("Could not find employee with id: " + id);
    }
}
