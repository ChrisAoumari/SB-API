package com.example.testapi.repo;

import com.example.testapi.models.entity.WorkHours;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {

    List<WorkHours> findByEmployeeId(Long employeeId);
}

