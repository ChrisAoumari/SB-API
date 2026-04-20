package com.example.testapi.Mapper;

import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.pojo.EmployeeDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto( @MappingTarget Employee employee, EmployeeDto employeeDto);

}
