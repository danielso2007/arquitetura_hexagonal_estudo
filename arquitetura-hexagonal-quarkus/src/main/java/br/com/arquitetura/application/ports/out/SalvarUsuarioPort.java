package br.com.arquitetura.application.ports.out;

import br.com.arquitetura.application.core.domain.Usuario;

public interface SalvarUsuarioPort {

    Usuario salvar(Usuario usuario);

}
