package com.example.testapi.controller;

import com.example.testapi.models.pojo.*;
import com.example.testapi.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmploymentService employmentService;
    private final PhonesService phonesService;
    private final SalaryService salaryService;
    private final WorkHoursService workHoursService;
    private final WorkLeaveService workLeaveService;

    @GetMapping
    public List<EmployeeDto> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public void createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto updatedDto) {
        employeeService.updateEmployee(id, updatedDto);
    }

    @PatchMapping("/{id}")
    public void patchEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto updatedDto) {
        employeeService.patchEmployee(id, updatedDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping("/{id}/employment")
    public List<EmploymentDto> getEmploymentByEmployeeId(@PathVariable Long id){
        return employmentService.getEmploymentByEmployeeID(id);
    }

    @GetMapping("/{id}/phones")
    public List<PhonesDto> getPhonesByEmployeeId(@PathVariable Long id){
        return phonesService.getPhoneByEmployeeId(id);
    }

    @GetMapping("/{id}/salary")
    public List<SalaryDto> getSalaryByEmployeeId(@PathVariable Long id){
        return salaryService.getSalaryByEmployeeId(id);
    }

    @GetMapping("/{id}/workHours")
    public List<WorkHoursDto> getWorkHoursByEmployeeId(@PathVariable Long id){
        return workHoursService.getWorkHoursByEmployeeId(id);
    }

    @GetMapping("/{id}/workLeave")
    public List<WorkLeaveDto> getWorkLeaveByEmployeeId(@PathVariable Long id){
        return workLeaveService.getWorkLeaveByEmployeeId(id);
    }

}
