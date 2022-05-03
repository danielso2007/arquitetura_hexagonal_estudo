package br.com.arquitetura.adapters.outbound;

import br.com.arquitetura.adapters.outbound.rest.BuscarEnderecoRest;
import br.com.arquitetura.application.core.domain.Endereco;
import br.com.arquitetura.application.ports.out.BuscarEnderecoPort;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BuscarEnderecoAdapter implements BuscarEnderecoPort {

    @Inject
    @RestClient
    BuscarEnderecoRest buscarEnderecoRest;

    @Override
    public Endereco buscar(String cep) {
        return buscarEnderecoRest.buscar(cep);
    }
}
