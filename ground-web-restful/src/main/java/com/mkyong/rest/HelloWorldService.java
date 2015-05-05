package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ground.Country;
import com.ground.common.constants.HelloService;
import com.ground.service.database.jdbc.ExportsIPBean;
import com.ground.service.database.jdbc.ExportsJDBC_BS;
import com.ground.service.database.jdbc.ExportsOPBean;
import com.ground.service.database.jdbc.GDException;

@Path("/web")
public class HelloWorldService {

	@Autowired
	@Qualifier("helloService")
	private HelloService helloService;
	
	@Autowired
	ExportsJDBC_BS exportsJDBC_BS;

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg111(@PathParam("param") String msg) {

		Country country = new Country();
		country.setName(helloService.getName(msg));
		country.setCapital(helloService.getGreeting1(msg));
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
	
	@GET
	@Path("/kk")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg112() {
		return Response.status(200).entity("Mritunjay").build();
	}

}