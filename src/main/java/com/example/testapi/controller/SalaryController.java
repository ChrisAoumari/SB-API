package com.example.testapi.controller;

import com.example.testapi.models.entity.Salary;
import com.example.testapi.models.pojo.SalaryDto;
import com.example.testapi.service.SalaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/salary")
public class SalaryController {

    private final SalaryService salaryService;

    @GetMapping
    public List<SalaryDto> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @GetMapping("/{id}")
    public SalaryDto getSalaryById(@PathVariable Long id){
        return salaryService.getSalaryById(id);
    }

    @PostMapping
    public void createSalary(@Valid @RequestBody SalaryDto salaryDto){
        salaryService.createSalary(salaryDto);
    }

    @PutMapping("/{id}")
    public void updateSalary(@PathVariable Long id, @Valid @RequestBody SalaryDto updatedDto){
        salaryService.updateSalary(id, updatedDto);
    }

    @PatchMapping("/{id}")
    public void patchSalary(@PathVariable Long id, @Valid @RequestBody SalaryDto updatedDto){
        salaryService.patchSalary(id, updatedDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSalary(@PathVariable Long id){
        salaryService.deleteSalary(id);
    }
}
