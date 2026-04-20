package com.example.testapi.repo;

import com.example.testapi.models.entity.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PhonesRepository extends JpaRepository<Phones, Long> {

    List<Phones> findByEmployeeId(Long employeeId);
}
