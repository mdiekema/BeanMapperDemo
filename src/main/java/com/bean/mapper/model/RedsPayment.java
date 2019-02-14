package com.bean.mapper.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RedsPayment {
	private String requestId;
	private String id;
	private String senderName;
	private PaymentStatus paymentStatus;
	private BigDecimal paymentAmount;
	private boolean isExpedited;
	private LocalDate created;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public boolean isExpedited() {
		return isExpedited;
	}

	public void setExpedited(boolean isExpedited) {
		this.isExpedited = isExpedited;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

}
