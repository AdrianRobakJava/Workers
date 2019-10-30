package application;

import java.util.ArrayList;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String address;
	private String departament;
	private String position;
	private String idNumber;
	private String salary;
	private String salaryList;
	private String bonus;
	private String bonusList;
	private String comments;
	
	public Employee(String fn, String ln, String id) {
		firstName = fn;
		lastName = ln;
		idNumber = id;
	}
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSalaryList() {
		return salaryList;
	}

	public void setSalaryList(String salaryList) {
		this.salaryList = salaryList;
	}

	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getBonusList() {
		return bonusList;
	}

	public void setBonusList(String bonusList) {
		this.bonusList = bonusList;
	}
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
