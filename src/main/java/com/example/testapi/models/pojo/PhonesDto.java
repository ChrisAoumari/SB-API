package com.example.testapi.models.pojo;

import com.example.testapi.models.entity.Phones;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.*;

@Data
@Builder
public class PhonesDto {

    private Long id;
    @NotNull(message = "EmployeeId is required")
    private Long employeeId;
    @NotBlank(message = "Phone number is required")
    private String phone;

    public static PhonesDto fromEntity(Phones phones){
        return PhonesDto.builder()
                .phone(phones.getPhone())
                .build();
    }

}
