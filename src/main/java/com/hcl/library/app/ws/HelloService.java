package com.hcl.library.app.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/{clientName}")
public class HelloService extends Application{

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response greetClient(@PathParam("clientName") String name) {
		String output = "Hi " + name;
		return Response.status(200).entity(output).build();
	}

}
