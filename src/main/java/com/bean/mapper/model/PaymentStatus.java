package com.bean.mapper.model;

public enum PaymentStatus {
	PENDING(1, "pending", "Pending payment"),
	SENT(2, "sent", "Payment sent"),
	FAILED(3, "failed", "Payment failed"),
	EXPIRED(4, "expired", "Payment expired");

	private int id;
	private String code;
	private String description;

	private PaymentStatus(int id, String code, String description) {
		this.id = id;
		this.code = code;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
