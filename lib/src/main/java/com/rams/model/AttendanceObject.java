package com.rams.model;

public class AttendanceObject {
	private String date;
	private String employeeId;
	private String timeIn;
	private String timeOut;
	private boolean locationIn;
	private boolean imageIn;
	private boolean locationOut;
	private boolean imageOut;
	
	public AttendanceObject(String date, String employeeId, String timeIn, String timeOut, boolean locationIn,
			boolean imageIn, boolean locationOut, boolean imageOut) {
		super();
		this.date = date;
		this.employeeId = employeeId;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.locationIn = locationIn;
		this.imageIn = imageIn;
		this.locationOut = locationOut;
		this.imageOut = imageOut;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public boolean isLocationIn() {
		return locationIn;
	}

	public void setLocationIn(boolean locationIn) {
		this.locationIn = locationIn;
	}

	public boolean isImageIn() {
		return imageIn;
	}

	public void setImageIn(boolean imageIn) {
		this.imageIn = imageIn;
	}

	public boolean isLocationOut() {
		return locationOut;
	}

	public void setLocationOut(boolean locationOut) {
		this.locationOut = locationOut;
	}

	public boolean isImageOut() {
		return imageOut;
	}

	public void setImageOut(boolean imageOut) {
		this.imageOut = imageOut;
	}
}