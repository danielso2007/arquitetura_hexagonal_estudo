package br.com.arquitetura.adapters.inbound;

import br.com.arquitetura.adapters.inbound.mapper.UsuarioMapper;
import br.com.arquitetura.adapters.inbound.request.UsuarioRequest;
import br.com.arquitetura.application.core.domain.Usuario;
import br.com.arquitetura.application.core.usercase.SalvarUsuarioService;
import br.com.arquitetura.commons.response.ErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuário", description = "Responsável pelo cadastro de usuário.")
public class UsuarioController {

    @Autowired
    SalvarUsuarioService salvarUsuarioService;

    @Autowired
    UsuarioMapper mapper;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = { "application/json;charset=utf-8" }, consumes = { "application/json;charset=utf-8" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registros gravado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Erro no cadastro", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = "application/json", schema = @Schema(allOf = ErrorResponse.class))) })
    public Usuario salvarUsuario(@RequestBody @Validated UsuarioRequest usuarioRequest) {
        var usuario = mapper.requestToUsuario(usuarioRequest);
        return salvarUsuarioService.salvarUsuario(usuario, usuarioRequest.getCep());
    }

}