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
        if (employeeRepository.existsById(id)) {
            return false;
        } else return true;
    }

    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);

    }

    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> get(String email, String dni) {
        List<EmployeeEntity> employees = employeeRepository.findByEmailAndDni(email, dni);
        /**
         //If you'd like to get all data without filter, you can try with findAll() function
         List<EmployeeEntity> employees = employeeRepository.findAll();
         **/
        return employees;
    }

}
