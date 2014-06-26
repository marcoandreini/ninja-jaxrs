package rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Preconditions;

import ninja.utils.NinjaProperties;

@Path("v1/hello")
public class Hello {
	
	private final NinjaProperties conf;
	
	@Inject
	Hello(NinjaProperties conf) {
		Preconditions.checkNotNull(conf);
		this.conf = conf;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloWorld() {
		return "Hello world... " + conf;
	}
}
