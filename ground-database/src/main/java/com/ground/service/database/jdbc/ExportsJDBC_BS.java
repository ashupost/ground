/*
 * ExportsBS.java
 *
 * Copyright 2008 by American Express, Inc., All rights reserved.
 * This software is the confidential and proprietary information
 * of American Express, Inc. ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of  the license agreement
 * you entered into with American Express.
 */
package com.ground.service.database.jdbc;

public class ExportsJDBC_BS extends GDJDBCAbstractBusinessService {

	@SuppressWarnings("unused")
	private final static String CLASS_NAME = "com.ground.dao.jdbc.ExportsJDBC_BS";

	public ExportsOPBean getLoginList(ExportsIPBean exportsInputValueBean) throws GDException {
		@SuppressWarnings("unused")
		final String METHOD_NAME = "getLoginList";
		ExportsOPBean exportOutputValueBean = null;
		try {
			exportsInputValueBean.setUniqueId("12345");
			exportOutputValueBean = (ExportsOPBean) getJDBCDataService("loginJDBCListDS", exportsInputValueBean);
			System.out.println(exportOutputValueBean);
			return exportOutputValueBean;
		} catch (Throwable e) {
			throw new GDException();
		}
	}
}