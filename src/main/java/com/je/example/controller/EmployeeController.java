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
     * Search all employees info on database
     *
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity<List<EmployeeEntity>> get(@RequestParam("id") Long id, @RequestParam("dni") String dni) {

        return ResponseEntity.ok(employeeService.get());
    }

    /**
     * Employe to modify info about a employee on database
     *
     * @param employeeEntity
     * @return
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeEntity> update(@PathVariable("id") Long id, @RequestBody EmployeeEntity employeeEntity) {
        return ResponseEntity.ok(employeeService.update(employeeEntity));
    }

    /**
     * Save info about a employee on database
     *
     * @param employeeEntity
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<EmployeeEntity> save(@RequestBody EmployeeEntity employeeEntity) {
        return ResponseEntity.ok(employeeService.save(employeeEntity));
    }


    /**
     * Method to delete info about employee on database
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long id) {
        return ResponseEntity.status(employeeService.delete(id) != false ? 200 : 500).build();
    }

}
