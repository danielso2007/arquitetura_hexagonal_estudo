package br.com.arquitetura.commons.exceptionmapper;

import br.com.arquitetura.commons.response.ErrorResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AppExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        System.err.println(ExceptionUtils.getRootCauseMessage(exception));
        System.err.println(ExceptionUtils.getStackTrace(exception));
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ErrorResponse.of(exception)).build();
    }

}

