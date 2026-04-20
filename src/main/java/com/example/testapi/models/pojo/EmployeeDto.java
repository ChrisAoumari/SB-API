package com.example.testapi.models.pojo;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.*;

@Data
@Builder
public class EmployeeDto {

    private Long id;
    private String firstName;
    @NotBlank(message = "Last Name is required")
    private String lastName;
    private String fatherName;
    private String motherName;
    @NotNull(message = "AFM is required")
    private Long afm;
    @NotNull(message = "AMKA is required")
    private Long amka;
    private String address;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    private Integer childNum;
    private String maritalStatus;
    private String education;
    private Boolean active;

}
