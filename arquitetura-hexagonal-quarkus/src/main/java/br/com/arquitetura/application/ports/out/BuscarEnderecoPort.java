package br.com.arquitetura.application.ports.out;

import br.com.arquitetura.application.core.domain.Endereco;

public interface BuscarEnderecoPort {

    Endereco buscar(String cep);

}
