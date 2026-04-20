package com.example.testapi.service;

import com.example.testapi.Mapper.WorkLeaveMapper;
import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.entity.WorkLeave;
import com.example.testapi.models.pojo.WorkLeaveDto;
import com.example.testapi.repo.EmployeeRepository;
import com.example.testapi.repo.WorkLeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkLeaveService {

    private final WorkLeaveRepository workLeaveRepository;
    private final EmployeeRepository employeeRepository;
    private final WorkLeaveMapper workLeaveMapper;

    public List<WorkLeaveDto> getAllWorkLeave(){
        return workLeaveRepository.findAll()
                .stream()
                .map(WorkLeaveDto::fromEntity)
                .toList();
    }

    public List<WorkLeaveDto> getWorkLeaveByEmployeeId(Long employeeId){
        return workLeaveRepository.findByEmployeeId(employeeId)
                .stream()
                .map(WorkLeaveDto::fromEntity)
                .toList();
    }

    public WorkLeaveDto getWorkLeaveById(Long id){
        WorkLeave workleave = workLeaveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Work leave not found"));
        return WorkLeaveDto.fromEntity(workleave);
    }

    public void createWorkLeave(WorkLeaveDto workLeaveDto){
        workLeaveRepository.save(workLeaveMapper.toEntity(workLeaveDto));
    }

    public void updateWorkLeave(Long id, WorkLeaveDto updatedDto){
        WorkLeave existing = workLeaveRepository.findById(id).orElseThrow();
        Employee managedEmployee = employeeRepository.findById(updatedDto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setEmployee(managedEmployee);
        existing.setLeaveType(updatedDto.getLeaveType());
        existing.setStartDate(updatedDto.getStartDate());
        existing.setEndDate(updatedDto.getEndDate());
        workLeaveRepository.save(existing);
    }

    public void patchWorkLeave(Long id, WorkLeaveDto updatedDto){
        WorkLeave existing = workLeaveRepository.findById(id).orElseThrow();
        Employee managedEmployee = employeeRepository.findById(updatedDto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        workLeaveMapper.updateEntityFromDto(existing, updatedDto);
        existing.setEmployee(managedEmployee);
        workLeaveRepository.save(existing);
    }

    public void deleteWorkLeave(Long id){
        workLeaveRepository.deleteById(id);
    }
}
