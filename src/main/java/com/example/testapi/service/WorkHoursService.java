package com.example.testapi.service;

import com.example.testapi.Mapper.WorkHoursMapper;
import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.entity.WorkHours;
import com.example.testapi.models.pojo.WorkHoursDto;
import com.example.testapi.repo.EmployeeRepository;
import com.example.testapi.repo.WorkHoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkHoursService {

    private final WorkHoursRepository workHoursRepository;
    private final EmployeeRepository employeeRepository;
    private final WorkHoursMapper workHoursMapper;

    public List<WorkHoursDto> getAllWorkHours(){
        return workHoursRepository.findAll()
                .stream()
                .map(WorkHoursDto::fromEntity)
                .toList();
    }

    public List<WorkHoursDto> getWorkHoursByEmployeeId(Long employeeId){
        return workHoursRepository.findByEmployeeId(employeeId)
                .stream()
                .map(WorkHoursDto::fromEntity)
                .toList();
    }

    public WorkHoursDto getWorkHoursById(Long id){
        WorkHours workHours = workHoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Work hours not found"));
        return WorkHoursDto.fromEntity(workHours);
    }

    public void createWorkHours(WorkHoursDto workHoursDto){
        workHoursRepository.save(workHoursMapper.toEntity(workHoursDto));
    }

    public void deleteWorkHours(Long id){
        workHoursRepository.deleteById(id);
    }

    public void updateWorkHours(Long id, WorkHoursDto updatedDto){
        WorkHours existing = workHoursRepository.findById(id).orElseThrow();
        Employee managedEmployee = employeeRepository.findById(updatedDto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setEmployee(managedEmployee);
        existing.setDate(updatedDto.getDate());
        existing.setHours(updatedDto.getHours());
        workHoursRepository.save(existing);
    }

    public void patchWorkHours(Long id, WorkHoursDto updatedDto){
        WorkHours existing = workHoursRepository.findById(id).orElseThrow();
        workHoursMapper.updateEntityFromDto(existing, updatedDto);
        Employee managedEmployee = employeeRepository.findById(updatedDto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setEmployee(managedEmployee);
        workHoursRepository.save(existing);
    }
}
