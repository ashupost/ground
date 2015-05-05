package com.ground;

import java.io.Serializable;
import java.util.List;

public class ResponseResult  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<ResultRequest> resultRequestList;
	
	private List<ResultSession> sessionList;
	
	

	
	
	
	

	public List<ResultSession> getSessionList() {
		return sessionList;
	}

	public void setSessionList(List<ResultSession> sessionList) {
		this.sessionList = sessionList;
	}

	public List<ResultRequest> getResultRequestList() {
		return resultRequestList;
	}

	public void setResultRequestList(List<ResultRequest> resultRequestList) {
		this.resultRequestList = resultRequestList;
	}
	

	
}
