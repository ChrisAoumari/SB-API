package com.example.testapi.controller;

import com.example.testapi.models.entity.WorkLeave;
import com.example.testapi.models.pojo.WorkLeaveDto;
import com.example.testapi.service.WorkLeaveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workLeave")
public class WorkLeaveController {

    private final WorkLeaveService workLeaveService;

    @GetMapping
    public List<WorkLeaveDto> getAllWorkLeave(){
        return workLeaveService.getAllWorkLeave();
    }

    @GetMapping("/{id}")
    public WorkLeaveDto getWorkLeaveById(@PathVariable Long id){
        return workLeaveService.getWorkLeaveById(id);
    }

    @PostMapping
    public void createWorkLeave(@Valid @RequestBody WorkLeaveDto workLeaveDto){
        workLeaveService.createWorkLeave(workLeaveDto);
    }

    @PutMapping("/{id}")
    public void updateWorkLeave(@PathVariable Long id, @Valid @RequestBody WorkLeaveDto updatedDto){
        workLeaveService.updateWorkLeave(id, updatedDto);
    }

    @PatchMapping("/{id}")
    public void patchWorkLeave(@PathVariable Long id, @Valid @RequestBody WorkLeaveDto updatedDto){
        workLeaveService.patchWorkLeave(id, updatedDto);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkLeave(@PathVariable Long id){
        workLeaveService.deleteWorkLeave(id);
    }
}
