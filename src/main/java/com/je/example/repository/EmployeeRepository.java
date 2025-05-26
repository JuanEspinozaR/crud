package com.je.example.repository;

import com.je.example.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query(value = "SELECT * FROM employee WHERE (:email IS NULL OR email = :email) AND (:dni IS NULL OR dni = :dni)", nativeQuery = true)
    List<EmployeeEntity> findByEmailAndDni(
            @Param("email") String email,
            @Param("dni") String dni
    );

}
