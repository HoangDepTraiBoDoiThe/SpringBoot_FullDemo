package com.example.fulldemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository repository) {
        employeeRepository = repository;
    }

    @GetMapping("/employees")
    List<Employee> All() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    Employee getEmployee(@PathVariable long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/{id}")
    ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeNewInfo) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeNewInfo.getName());
            employee.setRole(employeeNewInfo.getRole());
            return employeeRepository.save(employee);
        }).map(ResponseEntity::ok).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable long id) {
        employeeRepository.deleteById(id);
    }
}
