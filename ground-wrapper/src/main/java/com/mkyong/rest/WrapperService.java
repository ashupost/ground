package com.mkyong.rest;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ground.Country;
import com.ground.ResponseResult;
import com.ground.ResultRequest;
import com.ground.ResultSession;
import com.ground.common.constants.HelloService;
import com.ground.service.database.jdbc.ExportsIPBean;
import com.ground.service.database.jdbc.ExportsJDBC_BS;
import com.ground.service.database.jdbc.ExportsOPBean;
import com.ground.service.database.jdbc.GDException;

@Path("/wrapper")
public class WrapperService {

	@Autowired
	@Qualifier("helloService")
	private HelloService helloService;
	
	@Autowired
	ExportsJDBC_BS exportsJDBC_BS;
	
	@Context
	private HttpServletRequest request;
	
	@Context 
	HttpHeaders headers;
	
	@GET
	@Path("/config")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetails(@HeaderParam("RRRR1") String input)  {
		System.out.println("Input="+input);
		ResponseResult responseResult = new ResponseResult();
		List<ResultRequest> resultRequestList = new ArrayList<ResultRequest>();
		ResultRequest resultRequest = null;
		for(String header : headers.getRequestHeaders().keySet()){
			resultRequest = new ResultRequest();
			resultRequest.setRequestHeaderName(header);
			resultRequest.setRequestHeaderValue(headers.getHeaderString(header));
			resultRequestList.add(resultRequest);
		}
		responseResult.setResultRequestList(resultRequestList);
		
		
		HttpSession session =request.getSession();
		
		Enumeration<?> sessionEnum = session.getAttributeNames();
		List<ResultSession> sessionList = new ArrayList<ResultSession>();
		ResultSession resultSession=null;
		while(sessionEnum.hasMoreElements()){
			String object= (String)sessionEnum.nextElement();
			
			String att = (String)session.getAttribute(object);
			resultSession = new ResultSession();
			resultSession.setSessionKey(object);
			resultSession.setSessionValue(att);
			sessionList.add(resultSession);
			
		}
		responseResult.setSessionList(sessionList);
		return Response.status(200).entity(responseResult).build();
		
	}
	
	@GET
	@Path("/session")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSalesession(HttpServletRequest request1) {
		System.out.println("KKKKKKKKKKK");
		return Response.status(200).entity("Success").build();
		
	}
	

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg111(@PathParam("param") String msg)  {

		Country country = new Country();
		country.setName(helloService.getName(msg));
		country.setCapital(helloService.getGreeting1(msg));
		
		//ExportsJDBC_BS bs=(ExportsJDBC_BS) GDApplicationContextManager.getBusinessService("exportsJDBC_BS");
		ExportsIPBean bean = new ExportsIPBean();
		ExportsOPBean opBean = null;
		try {
			opBean= exportsJDBC_BS.getLoginList(bean);
		} catch (GDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(opBean).build();

	}

}