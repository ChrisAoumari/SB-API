package com.example.testapi.repo;

import com.example.testapi.models.entity.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {

    List<Employment> findByEmployeeId(Long employeeID);
}
