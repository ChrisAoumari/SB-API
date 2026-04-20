package com.example.testapi.service;

import com.example.testapi.Mapper.SalaryMapper;
import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.entity.Phones;
import com.example.testapi.models.entity.Salary;
import com.example.testapi.models.pojo.PhonesDto;
import com.example.testapi.models.pojo.SalaryDto;
import com.example.testapi.repo.EmployeeRepository;
import com.example.testapi.repo.SalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryService {

    private final SalaryRepository salaryRepository;
    private final EmployeeRepository employeeRepository;
    private final SalaryMapper salaryMapper;

    public List<SalaryDto> getAllSalary() {
        return salaryRepository.findAll()
                .stream()
                .map(SalaryDto::fromEntity)
                .toList();
    }

    public List<SalaryDto> getSalaryByEmployeeId(Long employeeId) {
        return salaryRepository.findByEmployeeId(employeeId)
                .stream()
                .map(SalaryDto::fromEntity)
                .toList();
    }

    public SalaryDto getSalaryById(Long id) {
        Salary salary = salaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary not found"));
        return SalaryDto.fromEntity(salary);
    }

    public void createSalary(SalaryDto salaryDto) {
        salaryRepository.save(salaryMapper.toEntity(salaryDto));
    }

    public void deleteSalary(Long id) {
        salaryRepository.deleteById(id);
    }

    public void updateSalary(Long id, SalaryDto updatedDto) {
        Salary existing = salaryRepository.findById(id).orElseThrow();
        Employee managedEmployee = employeeRepository.findById(updatedDto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setEmployee(managedEmployee);
        existing.setSalaryType(updatedDto.getSalaryType());
        existing.setSalaryAmount(updatedDto.getSalaryAmount());
        existing.setStartDate(updatedDto.getStartDate());
        existing.setEndDate(updatedDto.getEndDate());
        salaryRepository.save(existing);
    }

    public void patchSalary(Long id, SalaryDto updatedDto) {
        Salary existing = salaryRepository.findById(id).orElseThrow();
        salaryMapper.updateEntityFromDto(existing, updatedDto);
        Employee managedEmployee = employeeRepository.findById(updatedDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setEmployee(managedEmployee);
        salaryRepository.save(existing);
    }
}
