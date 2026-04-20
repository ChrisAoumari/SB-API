package com.example.testapi.models.pojo;

import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.entity.Employment;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import jakarta.validation.constraints.*;


@Data
@Builder
public class EmploymentDto {

    private Long id;
    @NotNull(message = "EmployeeId is required")
    private Long employeeId;
    @NotBlank(message = "Position is required")
    private String position;
    @NotBlank(message = "Department is required")
    private String department;
    @NotBlank(message = "Employment type is required")
    private String employmentType;
    @NotNull(message = "Employment start date is required")
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public static EmploymentDto fromEntity(Employment employment){
        return EmploymentDto.builder()
                .position(employment.getPosition())
                .department(employment.getDepartment())
                .employmentType(employment.getEmploymentType())
                .employmentStart(employment.getEmploymentStart())
                .employmentEnd(employment.getEmploymentEnd())
                .build();
    }
}
