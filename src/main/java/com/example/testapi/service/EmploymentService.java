package com.example.testapi.service;

import com.example.testapi.Mapper.EmploymentMapper;
import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.entity.Employment;
import com.example.testapi.models.pojo.EmploymentDto;
import com.example.testapi.repo.EmployeeRepository;
import com.example.testapi.repo.EmploymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmploymentService {

    private final EmploymentRepository employmentRepository;
    private final EmployeeRepository employeeRepository;
    private final EmploymentMapper employmentMapper;

    public List<EmploymentDto> getAllEmployment() {
        return employmentRepository.findAll()
                .stream()
                .map(employmentMapper::toDto)
                .toList();
    }

    public List<EmploymentDto> getEmploymentByEmployeeID(Long employeeId){
        return employmentRepository.findByEmployeeId(employeeId)
                .stream()
                .map(employmentMapper::toDto)
                .toList();
    }

    public EmploymentDto getEmploymentById(Long id){
        Employment employment = employmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employment info not found"));
        return employmentMapper.toDto(employment);
    }

    public void createEmployment(EmploymentDto employmentDto){
        Employment employment = employmentMapper.toEntity(employmentDto);

        Employee managedEmployee = employeeRepository
                .findById(employmentDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employment.setEmployee(managedEmployee);

        employmentRepository.save(employment);
    }

    public void deleteEmployment(Long id){
        employmentRepository.deleteById(id);
    }

    public void updateEmployment(Long id, EmploymentDto updatedDto){
        Employment existing = employmentRepository.findById(id).orElseThrow();
        Employee managedEmployee = employeeRepository.findById(updatedDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setPosition(updatedDto.getPosition());
        existing.setDepartment(updatedDto.getDepartment());
        existing.setEmploymentType(updatedDto.getEmploymentType());
        existing.setEmploymentStart(updatedDto.getEmploymentStart());
        existing.setEmploymentEnd(updatedDto.getEmploymentEnd());
        existing.setEmployee(managedEmployee);
        employmentRepository.save(existing);
    }

    public void patchEmployment(Long id, EmploymentDto updatedDto){
        Employment existing = employmentRepository.findById(id).orElseThrow();
        employmentMapper.updateEntityFromDto(existing, updatedDto);
        Employee managedEmployee = employeeRepository.findById(updatedDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setEmployee(managedEmployee);
        employmentRepository.save(existing);
    }
}
