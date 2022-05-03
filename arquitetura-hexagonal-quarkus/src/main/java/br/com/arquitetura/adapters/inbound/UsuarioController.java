package br.com.arquitetura.adapters.inbound;

import br.com.arquitetura.adapters.inbound.mapper.UsuarioMapper;
import br.com.arquitetura.adapters.inbound.request.UsuarioRequest;
import br.com.arquitetura.application.core.domain.Usuario;
import br.com.arquitetura.application.core.usercase.SalvarUsuarioService;
import br.com.arquitetura.commons.response.ErrorResponse;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    SalvarUsuarioService salvarUsuarioService;

    @Inject
    UsuarioMapper mapper;

    @POST
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Registros gravado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(type = SchemaType.ARRAY, implementation = Usuario.class))),
            @APIResponse(responseCode = "400", description = "Erro no cadastro", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = "application/json", schema = @Schema(allOf = ErrorResponse.class))) })
    @Tag(name = "Usuário", description = "Cadastro de usuário")
    public Usuario salvarUsuario(UsuarioRequest usuarioRequest) {
        var usuario = mapper.requestToUsuario(usuarioRequest);
        return salvarUsuarioService.salvarUsuario(usuario, usuarioRequest.getCep());
    }

}