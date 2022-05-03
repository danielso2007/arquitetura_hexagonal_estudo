package br.com.arquitetura.commons.config;

import br.com.arquitetura.application.core.usercase.SalvarUsuarioService;
import br.com.arquitetura.application.ports.out.BuscarEnderecoPort;
import br.com.arquitetura.application.ports.out.SalvarUsuarioPort;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SalvarUsuarioService salvarUsuarioService(SalvarUsuarioPort salvarUsuarioPort, BuscarEnderecoPort buscarEnderecoPort) {
        return new SalvarUsuarioService(salvarUsuarioPort, buscarEnderecoPort);
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

}
