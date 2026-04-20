package com.example.testapi.service;

import com.example.testapi.Mapper.PhonesMapper;
import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.entity.Employment;
import com.example.testapi.models.entity.Phones;
import com.example.testapi.models.pojo.PhonesDto;
import com.example.testapi.repo.EmployeeRepository;
import com.example.testapi.repo.PhonesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhonesService {

    private final PhonesRepository phonesRepository;
    private final EmployeeRepository employeeRepository;
    private final PhonesMapper phonesMapper;

    public List<PhonesDto> getAllPhones(){
        return phonesRepository.findAll()
                .stream()
                .map(PhonesDto::fromEntity)
                .toList();
    }

    public List<PhonesDto> getPhoneByEmployeeId(Long employeeId){
        return phonesRepository.findByEmployeeId(employeeId)
                .stream()
                .map(PhonesDto::fromEntity)
                .toList();
    }

    public PhonesDto getPhoneById(Long id){
        Phones phones = phonesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        return PhonesDto.fromEntity(phones);
    }

    public void createPhone(PhonesDto phonesDto){
        phonesRepository.save(phonesMapper.toEntity(phonesDto));
    }

    public void deletePhone(Long id){
        phonesRepository.deleteById(id);
    }

    public void updatePhone(Long id, PhonesDto updatedDto){
        Phones existing = phonesRepository.findById(id).orElseThrow();
        Employee managedEmployee = employeeRepository.findById(updatedDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setPhone(updatedDto.getPhone());
        existing.setEmployee(managedEmployee);
        phonesRepository.save(existing);
    }

    public void patchPhone(Long id, PhonesDto updatedDto){
        Phones existing = phonesRepository.findById(id).orElseThrow();
        phonesMapper.updateEntityFromDto(existing, updatedDto);
        Employee managedEmployee = employeeRepository.findById(updatedDto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setEmployee(managedEmployee);
        phonesRepository.save(existing);
    }
}
