package com.example.testapi.Mapper;

import com.example.testapi.models.entity.Salary;
import com.example.testapi.models.pojo.SalaryDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SalaryMapper {
    @Mapping(source = "employee.id", target = "employeeId")
    SalaryDto toDto(Salary salary);
    @Mapping(target = "employee", ignore = true)
    Salary toEntity(SalaryDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(@MappingTarget Salary salary, SalaryDto salaryDto);
}
