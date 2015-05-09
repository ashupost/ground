package com.ground.service.database.jdbc;

public class GDUserBean extends GDValueBean {
	private static final long serialVersionUID = 1L;

	private Integer userID = null;
	private String userPassword = null;
	private String userName = null;
	private String userEmail = null;
	private String userFirstName = null;
	private String userLastName = null;

	private String rowPerPage = "10";
	private String currentPage = "1";
	private String roleId = null;
	private String userType = null;
	private String userLocalePref = null;
	private String countryCode = null;
	private Double userLagitude = null;
	private Double userLongitude = null;
	private String userLankMark = null;
	private String userPhone = null;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(String rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserLocalePref() {
		return userLocalePref;
	}

	public void setUserLocalePref(String userLocalePref) {
		this.userLocalePref = userLocalePref;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Double getUserLagitude() {
		return userLagitude;
	}

	public void setUserLagitude(Double userLagitude) {
		this.userLagitude = userLagitude;
	}

	public Double getUserLongitude() {
		return userLongitude;
	}

	public void setUserLongitude(Double userLongitude) {
		this.userLongitude = userLongitude;
	}

	public String getUserLankMark() {
		return userLankMark;
	}

	public void setUserLankMark(String userLankMark) {
		this.userLankMark = userLankMark;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

}
