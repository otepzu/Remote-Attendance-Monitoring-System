package com.rams.model;

import java.util.ArrayList;

public class EmployeeObject {
	private String employeeId; // Key
	private String firstName;
	private String middleName;
	private String lastName;
	private String username;
	private String password;
	private String defaultLocation;
	private String assignedLocation;
	
	private static ArrayList<String> empList = new ArrayList<String>();
	
	public static int getLength() {
		return empList.size();
	}
	
	public static void addEmp(String emp) {
		EmployeeObject.empList.add(emp);
	}
	
	public static String getEmp(int i) {
		return EmployeeObject.empList.get(i);
	}
	
	public static void setEmp(int i, String val) {
		EmployeeObject.empList.set(i, val);
	}
	
	public static void deleteEmp(int i) {
		EmployeeObject.empList.remove(i);
		EmployeeObject.empList.remove(i);
		EmployeeObject.empList.remove(i);
		EmployeeObject.empList.remove(i);
		EmployeeObject.empList.remove(i);
		EmployeeObject.empList.remove(i);
		EmployeeObject.empList.remove(i);
	}
	
	public static void clearEmp() {
		EmployeeObject.empList.clear();
	}
	
	public EmployeeObject(String employeeId, String firstName, String middleName, String lastName, String username,
			String password, String defaultLocation, String assignedLocation) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.defaultLocation = defaultLocation;
		this.assignedLocation = assignedLocation;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDefaultLocation() {
		return defaultLocation;
	}

	public void setDefaultLocation(String defaultLocation) {
		this.defaultLocation = defaultLocation;
	}

	public String getAssignedLocation() {
		return assignedLocation;
	}

	public void setAssignedLocation(String assignedLocation) {
		this.assignedLocation = assignedLocation;
	}
}
