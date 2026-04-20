package com.example.testapi.models.pojo;

import com.example.testapi.models.entity.WorkLeave;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class WorkLeaveDto {

    private Long id;
    @NotNull(message = "EmployeeId is required")
    private Long employeeId;
    @NotBlank(message = "Leave type is required")
    private String leaveType;
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    private LocalDate endDate;

    public static WorkLeaveDto fromEntity(WorkLeave workLeave){
        return WorkLeaveDto.builder()
                .leaveType(workLeave.getLeaveType())
                .startDate(workLeave.getStartDate())
                .endDate(workLeave.getEndDate())
                .build();
    }
}
