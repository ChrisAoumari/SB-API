package com.example.testapi.Mapper;

import com.example.testapi.models.entity.WorkHours;
import com.example.testapi.models.pojo.WorkHoursDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface WorkHoursMapper {
    @Mapping(source = "employee.id", target = "employeeId")
    WorkHoursDto toDto(WorkHours workHours);
    @Mapping(target = "employee", ignore = true)
    WorkHours toEntity(WorkHoursDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(@MappingTarget WorkHours workHours, WorkHoursDto workHoursDto);
}
