package com.example.testapi.controller;

import com.example.testapi.models.entity.WorkHours;
import com.example.testapi.models.pojo.WorkHoursDto;
import com.example.testapi.service.WorkHoursService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workHours")
public class WorkHoursController {

    private WorkHoursService workHoursService;

    @GetMapping
    public List<WorkHoursDto> getAllWorkHours(){
        return workHoursService.getAllWorkHours();
    }

    @GetMapping("/{id}")
    public WorkHoursDto getWorkHoursById(@PathVariable Long id){
        return workHoursService.getWorkHoursById(id);
    }

    @PostMapping
    public void createWorkHours(@Valid @RequestBody WorkHoursDto workHoursDto){
        workHoursService.createWorkHours(workHoursDto);
    }

    @PutMapping("/{id}")
    public void updateWorkHours(@PathVariable Long id, @Valid @RequestBody WorkHoursDto updatedDto){
        workHoursService.updateWorkHours(id, updatedDto);
    }

    @PatchMapping("/{id}")
    public void patchWorkHours(@PathVariable Long id, @Valid @RequestBody WorkHoursDto updatedDto){
        workHoursService.patchWorkHours(id, updatedDto);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkHours(@PathVariable Long id){
        workHoursService.deleteWorkHours(id);
    }
}
