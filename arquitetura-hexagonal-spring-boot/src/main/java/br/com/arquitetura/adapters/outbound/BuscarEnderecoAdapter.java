package br.com.arquitetura.adapters.outbound;

import br.com.arquitetura.adapters.outbound.rest.BuscarEnderecoRest;
import br.com.arquitetura.application.core.domain.Endereco;
import br.com.arquitetura.application.ports.out.BuscarEnderecoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarEnderecoAdapter implements BuscarEnderecoPort {

    @Autowired
    BuscarEnderecoRest buscarEnderecoRest;

    @Override
    public Endereco buscar(String cep) {
        return buscarEnderecoRest.buscar(cep);
    }
}
