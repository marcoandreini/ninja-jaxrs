package rest;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Preconditions;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import ninja.utils.NinjaProperties;

@Api(value="v1/hello", description="Hello world")
@Path("v1/hello")
public class Hello {
	
	private final Provider<EntityManager> emp;
	
	@Inject
	Hello(Provider<EntityManager> emp) {
		this.emp = emp;
	}

	@ApiOperation(value="say hello world", response=String.class)
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloWorld() {
		return "Hello world... " + emp.get().isOpen();
	}
}
