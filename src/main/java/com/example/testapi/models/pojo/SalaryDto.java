package com.example.testapi.models.pojo;

import com.example.testapi.models.entity.Salary;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;


@Data
@Builder
public class SalaryDto {

    private Long id;
    @NotNull(message = "EmployeeId is required")
    private Long employeeId;
    @NotBlank(message = "Salary type is required")
    private String salaryType;
    @NotNull(message = "Salary is required")
    private Integer salaryAmount;
    @NotNull(message = "Salary start date is required")
    private LocalDate startDate;
    private LocalDate endDate;

    public static SalaryDto fromEntity(Salary salary){
        return SalaryDto.builder()
                .salaryType(salary.getSalaryType())
                .salaryAmount(salary.getSalaryAmount())
                .startDate(salary.getStartDate())
                .endDate(salary.getEndDate())
                .build();
    }
}
