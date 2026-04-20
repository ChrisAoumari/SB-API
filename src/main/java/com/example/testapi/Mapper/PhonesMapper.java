package com.example.testapi.Mapper;

import com.example.testapi.models.entity.Phones;
import com.example.testapi.models.pojo.PhonesDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PhonesMapper {
    @Mapping(source = "employee.id", target = "employeeId")
    PhonesDto toDto(Phones phones);
    @Mapping(target = "employee", ignore = true)
    Phones toEntity(PhonesDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(@MappingTarget Phones phones, PhonesDto phonesDto);
}
