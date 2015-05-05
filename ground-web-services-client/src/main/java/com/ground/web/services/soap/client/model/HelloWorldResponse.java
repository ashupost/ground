package com.ground.web.services.soap.client.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = { "result", "status" })
public class HelloWorldResponse {

	private StatusType status;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HelloWorldResponse [status=" + status + ", result=" + result + ", getResult()=" + getResult() + ", getStatus()=" + getStatus() + "]";
	}

}
