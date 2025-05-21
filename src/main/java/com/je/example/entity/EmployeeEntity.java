package com.je.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
@Table(
        //Your database table name
        name = "employee"
)
public class EmployeeEntity {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dni")
    private String dni;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hireDate")
    private Date hireDate;
    @Column(name = "salary")
    private String salary;
}
