package com.example.testapi.controller;

import com.example.testapi.models.pojo.EmploymentDto;
import com.example.testapi.service.EmploymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employment")
@RequiredArgsConstructor
public class EmploymentController {

    private final EmploymentService employmentService;

    @GetMapping
    public List<EmploymentDto> getAllEmployment(){
        return employmentService.getAllEmployment();
    }

    @GetMapping("/{id}")
    public EmploymentDto getEmploymentById(@PathVariable Long id){
        return employmentService.getEmploymentById(id);
    }

    @PostMapping
    public void createEmployment(@Valid @RequestBody EmploymentDto employmentDto){
        employmentService.createEmployment(employmentDto);
    }

    @PutMapping("/{id}")
    public void updateEmployment(@PathVariable Long id, @Valid @RequestBody EmploymentDto updatedDto){
        employmentService.updateEmployment(id, updatedDto);
    }

    @PatchMapping("/{id}")
    public void patchEmployment(@PathVariable Long id, @Valid @RequestBody EmploymentDto updatedDto) {
        employmentService.patchEmployment(id, updatedDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployment(@PathVariable Long id){
        employmentService.deleteEmployment(id);
    }


}
