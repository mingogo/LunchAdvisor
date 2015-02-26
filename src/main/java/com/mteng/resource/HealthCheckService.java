package com.mteng.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test")
public class HealthCheckService {

	@GET
	public Response responseMsg() {

		String output = "Endpoint testing - SUCCESSFUL.";
		return Response.status(200).entity(output).build();
	}
}
