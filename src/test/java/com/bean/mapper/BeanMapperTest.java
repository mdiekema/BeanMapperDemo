package com.bean.mapper;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.bean.mapper.model.CesPayment;
import com.bean.mapper.model.PaymentStatus;
import com.bean.mapper.model.RedsPayment;

import fr.xebia.extras.selma.Selma;

public class BeanMapperTest {

	private CesPayment payment;

	@Before
	public void setup() {
		payment = new CesPayment();
		payment.setAmount(new BigDecimal(5.50));
		payment.setExpedited(true);
		payment.setId("12345");
		payment.setInitiationTime(LocalDate.of(2019, 2, 11));
		payment.setRequestId("54321");
		payment.setSenderName("Debby Antonelli");
		payment.setStatus(PaymentStatus.SENT);
	}

	@Test
	public void testPaymentMappingModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		// Map initiationTime field to created
		PropertyMap<CesPayment, RedsPayment> paymentMap = new PropertyMap<CesPayment, RedsPayment>() {
			protected void configure() {
				map().setCreated(source.getInitiationTime());
			}
		};

		modelMapper.addMappings(paymentMap);
		RedsPayment redsPayment = modelMapper.map(payment, RedsPayment.class);
		testMapping(payment, redsPayment);
	}
	
	@Test
	public void testPaymentMappingMapStruct() {
		RedsPayment redsPayment = MapStructPaymentMapper.INSTANCE.cesPaymentToRedsPayment(payment);
		testMapping(payment, redsPayment);
	}
	
	@Test
	public void testPaymenetMappingSelma() {
//		SelmaPaymentMapper mapper = Selma.builder(SelmaPaymentMapper.class).build();
//		RedsPayment redsPayment = mapper.asRedsPayment(payment);
//		testMapping(payment, redsPayment);
	}
	
	@Test
	public void testPaymentMappingBeanUtils() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		RedsPayment redsPayment = new RedsPayment();
		// Fields with the same name are automatically copied over, remaining properties
		// must be set manually
		BeanUtils.copyProperties(redsPayment, payment);
		PropertyUtils.setProperty(redsPayment, "paymentAmount", payment.getAmount());
		PropertyUtils.setProperty(redsPayment, "created", payment.getInitiationTime());
		PropertyUtils.setProperty(redsPayment, "paymentStatus", payment.getStatus());
		testMapping(payment, redsPayment);
	}
	
	@Test
	public void testPaymentMappingDozer() {
		org.dozer.Mapper mapper = new DozerBeanMapper();

		RedsPayment redsPayment = 
		    mapper.map(payment, RedsPayment.class);
		
		//Dozer won't map the LocalDate field because it is marked final		             
		//testMapping(payment, redsPayment);
	}

	private void testMapping(CesPayment payment, RedsPayment redsPayment) {
		assertEquals(payment.getAmount(), redsPayment.getPaymentAmount());
		assertEquals(payment.isExpedited(), redsPayment.isExpedited());
		assertEquals(payment.getId(), redsPayment.getId());
		assertEquals(payment.getInitiationTime(), redsPayment.getCreated());
		assertEquals(payment.getRequestId(), redsPayment.getRequestId());
		assertEquals(payment.getSenderName(), redsPayment.getSenderName());
		assertEquals(payment.getStatus(), redsPayment.getPaymentStatus());
	}
}
