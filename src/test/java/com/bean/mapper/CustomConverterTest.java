package com.bean.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

import com.bean.mapper.model.CesPayment;
import com.bean.mapper.model.RedsPayment;
import com.bean.mapper.model.custom.FromEmployee;
import com.bean.mapper.model.custom.ToEmployee;

public class CustomConverterTest {
	private FromEmployee fromEmployee;

	@Before
	public void setup() {
		fromEmployee = new FromEmployee();
		fromEmployee.setFirstName("Joe");
		fromEmployee.setLastName("Smith");
		fromEmployee.setEmployed(true);
		fromEmployee.setSalary(60000);
	}

	@Test
	public void testModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
//		PropertyMap<FromEmployee, ToEmployee> employeeMap = new PropertyMap<FromEmployee, ToEmployee>() {
//			protected void configure() {
//				map().setFirstName(source.getFirstName());
//				map().setLastName(source.getLastName());
//			}
//		};
		
		Converter<FromEmployee, ToEmployee> employeeConverter = new AbstractConverter<FromEmployee, ToEmployee>() {
			protected ToEmployee convert(FromEmployee source) {
				ToEmployee toEmployee = new ToEmployee();
				
				// These should be handled by a property map, since both objects have the same name
				toEmployee.setFirstName(source.getFirstName());
				toEmployee.setLastName(source.getLastName());
				
				toEmployee.setMonthlySalary(source.getSalary() / 12);
				toEmployee.setUnemployed(!fromEmployee.isEmployed());
				return toEmployee;
			}
		};
		
		TypeMap<FromEmployee, ToEmployee> typeMap = modelMapper.createTypeMap(FromEmployee.class, ToEmployee.class);
		typeMap.setConverter(employeeConverter);
		ToEmployee toEmployee = typeMap.map(fromEmployee);
		testMapping(fromEmployee, toEmployee);
	}

	@Test
	public void testMapStruct() {
		ToEmployee toEmployee = MapStructEmployeeMapper.INSTANCE.employeeToEmployeeDto(fromEmployee);
		testMapping(fromEmployee, toEmployee);
	}

	private void testMapping(FromEmployee fromEmployee, ToEmployee toEmployee) {
		assertEquals(fromEmployee.getFirstName(), toEmployee.getFirstName());
		assertEquals(fromEmployee.getLastName(), toEmployee.getLastName());
		assertEquals(fromEmployee.isEmployed(), !toEmployee.isUnemployed());
		assertEquals(fromEmployee.getSalary(), (toEmployee.getMonthlySalary() * 12), 1);
	}
}
