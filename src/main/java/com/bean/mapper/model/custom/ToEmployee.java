package com.bean.mapper.model.custom;

public class ToEmployee {
	private String firstName;
	private String lastName;
	private boolean isUnemployed;
	private double monthlySalary;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isUnemployed() {
		return isUnemployed;
	}

	public void setUnemployed(boolean isUnemployed) {
		this.isUnemployed = isUnemployed;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

}
