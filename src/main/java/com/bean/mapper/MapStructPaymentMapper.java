package com.bean.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.bean.mapper.model.CesPayment;
import com.bean.mapper.model.RedsPayment;

@Mapper
public interface MapStructPaymentMapper {
 
    MapStructPaymentMapper INSTANCE = Mappers.getMapper( MapStructPaymentMapper.class );
 
    @Mappings(
    {
    	@Mapping(source = "status", target = "paymentStatus"),
	    @Mapping(source = "amount", target = "paymentAmount"),
	    @Mapping(source = "expedited", target = "expedited"),
	    @Mapping(source = "initiationTime", target = "created")
    })
    RedsPayment cesPaymentToRedsPayment(CesPayment payment);
}