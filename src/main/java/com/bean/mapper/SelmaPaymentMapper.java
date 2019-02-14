package com.bean.mapper;

import com.bean.mapper.model.CesPayment;
import com.bean.mapper.model.RedsPayment;

import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;

@Mapper(
	withCustomFields = {
			@Field({ "status", "paymentStatus" }),
			@Field({ "amount", "paymentAmount" }),
			@Field({ "expedited", "expedited" }),
			@Field({ "initiationTime", "created" })
	}
)
public interface SelmaPaymentMapper {
	RedsPayment asRedsPayment(CesPayment payment);
}
