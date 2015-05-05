package com.ground.web.services.soap.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "statusType")
@XmlEnum
public enum StatusType {

	OK, FAIL;

	public String value() {
		return name();
	}

	public static StatusType fromValue(String v) {
		return valueOf(v);
	}

}