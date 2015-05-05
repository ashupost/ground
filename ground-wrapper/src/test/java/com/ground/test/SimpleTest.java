package com.ground.test;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

import com.mkyong.rest.WrapperService;

public class SimpleTest extends JerseyTest {

	@Override
	protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
		return new GrizzlyWebTestContainerFactory();
	}

	@Override
	protected DeploymentContext configureDeployment() {
		return ServletDeploymentContext.forServlet(new ServletContainer(new ResourceConfig(WrapperService.class))).build();
	}

	@Test
	public void test() {
		Response response = target("wrapper/config").request().header("RRRR1", "Mritunjay Kumar").get();
		System.out.println("response=" + response);
		// System.out.println(response.getEntity().toString());
		// assertThat(response.getStatus(), is(200));

	}
}