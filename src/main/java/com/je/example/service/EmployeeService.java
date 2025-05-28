package com.je.example.service;

import com.je.example.entity.EmployeeEntity;
import com.je.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public boolean delete(long id) {
        employeeRepository.deleteById(id);
        return !employeeRepository.existsById(id);
    }

    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> get(String email, String dni) {
        return employeeRepository.findByEmailAndDni(email, dni);
        /**
         * Tip: To retrieve all employees without filters,
         * you can use employeeRepository.findAll()
         */
    }
}