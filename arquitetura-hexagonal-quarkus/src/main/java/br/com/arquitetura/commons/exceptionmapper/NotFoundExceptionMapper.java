package br.com.arquitetura.commons.exceptionmapper;

import br.com.arquitetura.commons.response.ErrorResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        System.err.println(ExceptionUtils.getRootCauseMessage(exception));
        System.err.println(ExceptionUtils.getStackTrace(exception));
        return Response.status(Status.NOT_FOUND).entity(ErrorResponse.of(exception)).build();
    }

}

