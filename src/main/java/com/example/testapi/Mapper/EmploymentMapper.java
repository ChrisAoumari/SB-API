package com.example.testapi.Mapper;

import com.example.testapi.models.entity.Employment;
import com.example.testapi.models.pojo.EmploymentDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmploymentMapper {

    @Mapping(source = "employee.id", target = "employeeId")
    EmploymentDto toDto(Employment employment);

    @Mapping(target = "employee", ignore = true)
    Employment toEntity(EmploymentDto employmentDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(@MappingTarget Employment employment, EmploymentDto employmentDto);
}
