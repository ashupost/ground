package com.ground.web.services.soap.client.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroundSoapException", propOrder = { "faultInfo", "message" })
public class GroundSoapException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorDetails;

	public GroundSoapException(String cause, String errorDetails) {
		super(cause);
		this.errorDetails = errorDetails;
	}

	public String getFaultInfo() {
		return errorDetails;
	}
}
