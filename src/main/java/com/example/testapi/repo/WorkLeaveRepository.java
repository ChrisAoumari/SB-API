package com.example.testapi.repo;

import com.example.testapi.models.entity.WorkLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkLeaveRepository extends JpaRepository<WorkLeave, Long> {

    List<WorkLeave> findByEmployeeId(Long employeeId);
}
