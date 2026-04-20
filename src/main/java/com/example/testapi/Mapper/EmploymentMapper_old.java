package com.example.testapi.Mapper;

import com.example.testapi.models.entity.Employee;
import com.example.testapi.models.entity.Employment;
import com.example.testapi.models.pojo.EmploymentDto;
import com.example.testapi.repo.EmployeeRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class EmploymentMapper_old {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Mapping(source = "employee", target = "employeeId", qualifiedByName = "idFromEmployee")
    public abstract EmploymentDto toDto(Employment employment);
    @Mapping(source = "employeeId", target = "employee", qualifiedByName = "employeeFromId")
    public abstract Employment toEntity(EmploymentDto dto);

    @Named("employeeFromId")
    public Employee employeeFromId(Long id) {
        if (id == null) return null;
        return employeeRepository.findById(id).orElseThrow();
    }

    @Named("idFromEmployee")
    public Long idFromEmployee(Employee employee) {
        if (employee == null) return null;
        return employee.getId();
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "employeeId", target = "employee", qualifiedByName = "employeeFromId")
    public abstract void updateEntityFromDto(@MappingTarget Employment employment, EmploymentDto employmentDto);
}
