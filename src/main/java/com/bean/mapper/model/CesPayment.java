package com.bean.mapper.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CesPayment {
	private String id;
	private String requestId;
	private PaymentStatus status;
	private String senderName;
	private BigDecimal amount;
	private boolean expedited;
	private LocalDate initiationTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isExpedited() {
		return expedited;
	}

	public void setExpedited(boolean expedited) {
		this.expedited = expedited;
	}

	public LocalDate getInitiationTime() {
		return initiationTime;
	}

	public void setInitiationTime(LocalDate initiationTime) {
		this.initiationTime = initiationTime;
	}

}
