package com.hcl.library.app.ws.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.hcl.library.app.ws.model.response.ErrorMessage;
import com.hcl.library.app.ws.model.response.ErrorMessages;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {

		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
				ErrorMessages.INTERNAL_SERVER_ERROR.name());

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
