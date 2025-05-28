package com.je.example.controller;

import com.je.example.entity.EmployeeEntity;
import com.je.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * Retrieve employees, optionally filtered by DNI or email.
     */
    @GetMapping("/get")
    public ResponseEntity<List<EmployeeEntity>> get(
            @RequestParam(value = "dni", required = false) String dni,
            @RequestParam(value = "email", required = false) String email
    ) {
        return ResponseEntity.status(200).body(employeeService.get(email, dni));
    }

    /**
     * Update an existing employee's information by ID.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeEntity> update(
            @PathVariable("id") Long id,
            @RequestBody EmployeeEntity employeeEntity
    ) {
        employeeEntity.setId(id);
        return ResponseEntity.ok(employeeService.update(employeeEntity));
    }

    /**
     * Save a new employee to the database.
     */
    @PostMapping("/save")
    public ResponseEntity<EmployeeEntity> save(@RequestBody EmployeeEntity employeeEntity) {
        return ResponseEntity.ok(employeeService.save(employeeEntity));
    }

    /**
     * Delete an employee by ID.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        boolean deleted = employeeService.delete(id);
        return ResponseEntity.status(deleted ? 200 : 500).build();
    }
}