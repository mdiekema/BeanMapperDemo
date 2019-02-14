package com.bean.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.bean.mapper.model.custom.FromEmployee;
import com.bean.mapper.model.custom.ToEmployee;

@Mapper
public interface MapStructEmployeeMapper {
	
	MapStructEmployeeMapper INSTANCE = Mappers.getMapper( MapStructEmployeeMapper.class );

    default ToEmployee employeeToEmployeeDto(FromEmployee fromEmployee) {
        ToEmployee toEmployee = new ToEmployee();
        toEmployee.setFirstName(fromEmployee.getFirstName());
        toEmployee.setLastName(fromEmployee.getLastName());
        toEmployee.setMonthlySalary(fromEmployee.getSalary() / 12);
        toEmployee.setUnemployed(!fromEmployee.isEmployed());
        return toEmployee;
    }
}