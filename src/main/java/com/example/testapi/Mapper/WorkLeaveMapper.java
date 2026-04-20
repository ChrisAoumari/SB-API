package com.example.testapi.Mapper;

import com.example.testapi.models.entity.WorkLeave;
import com.example.testapi.models.pojo.WorkLeaveDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface WorkLeaveMapper {
    @Mapping(source = "employee.id", target = "employeeId")
    WorkLeaveDto toDto(WorkLeave workLeave);
    @Mapping(target = "employee", ignore = true)
    WorkLeave toEntity(WorkLeaveDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(@MappingTarget WorkLeave workLeave, WorkLeaveDto workLeaveDto);
}
