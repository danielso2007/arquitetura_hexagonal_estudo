package br.com.arquitetura.application.ports.in;

import br.com.arquitetura.application.core.domain.Usuario;

public interface SalvarUsuarioServicePort {

    Usuario salvarUsuario(Usuario usuario, String cep);

}
