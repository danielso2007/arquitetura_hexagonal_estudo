package br.com.arquitetura.commons.config;

import br.com.arquitetura.application.core.usercase.SalvarUsuarioService;
import br.com.arquitetura.application.ports.out.BuscarEnderecoPort;
import br.com.arquitetura.application.ports.out.SalvarUsuarioPort;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;

@Dependent
public class Config {

    @Default
    public SalvarUsuarioService salvarUsuarioService(SalvarUsuarioPort salvarUsuarioPort, BuscarEnderecoPort buscarEnderecoPort) {
        return new SalvarUsuarioService(salvarUsuarioPort, buscarEnderecoPort);
    }

}
