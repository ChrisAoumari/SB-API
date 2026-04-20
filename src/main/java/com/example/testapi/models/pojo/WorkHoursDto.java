package com.example.testapi.models.pojo;

import com.example.testapi.models.entity.WorkHours;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class WorkHoursDto {

    private Long id;
    @NotNull(message = "EmployeeId is required")
    private Long employeeId;
    @NotNull(message = "Hours are required")
    private Integer hours;
    @NotNull(message = "Date is required")
    private LocalDate date;

    public static WorkHoursDto fromEntity(WorkHours workHours){
        return WorkHoursDto.builder()
                .hours(workHours.getHours())
                .date(workHours.getDate())
                .build();
    }
}
