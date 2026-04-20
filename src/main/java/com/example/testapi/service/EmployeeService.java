package com.example.testapi.service;

import com.example.testapi.Mapper.EmployeeMapper;
import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.pojo.EmployeeDto;
import com.example.testapi.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

//TODO: Use mapstruct for Dto list
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .toList();
    }
//TODO: Handle errors
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeMapper.toDto(employee);
    }

    public void createEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.toEntity(employeeDto));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployee(Long id, EmployeeDto updatedDto) {
        Employee existing = employeeRepository.findById(id).orElseThrow();
        Employee updated = employeeMapper.toEntity(updatedDto);
        updated.setId(existing.getId());
        employeeRepository.save(updated);
    }

    public void patchEmployee(Long id, EmployeeDto updatedDto){
        Employee existing = employeeRepository.findById(id).orElseThrow();
        employeeMapper.updateEntityFromDto(existing, updatedDto);
        employeeRepository.save(existing);
    }

    /*public void updateEmployee(Long id, EmployeeDto updated) {
        Employee existing = employeeRepository.findById(id).orElseThrow();
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setFatherName(updated.getFatherName());
        existing.setMotherName(updated.getMotherName());
        existing.setAfm(updated.getAfm());
        existing.setAmka(updated.getAmka());
        existing.setAddress(updated.getAddress());
        existing.setEmail(updated.getEmail());
        existing.setChildNum(updated.getChildNum());
        existing.setMaritalStatus(updated.getMaritalStatus());
        existing.setEducation(updated.getEducation());
        existing.setActive(updated.getActive());
        employeeRepository.save(existing);
    }*/
}
