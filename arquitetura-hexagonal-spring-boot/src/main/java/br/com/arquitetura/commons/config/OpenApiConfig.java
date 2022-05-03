package br.com.arquitetura.commons.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        Contact contact = new Contact();
        contact.setName("Daniel Oliveira");
        contact.setUrl("https://github.com/danielso2007/arquitetura_hexagonal_estudo");
        contact.setEmail("danielso2007@gmail.com");

        License license = new License();
        license.setName("Proprietário");
        license.setUrl("https://github.com/danielso2007/arquitetura_hexagonal_estudo");

        List<Server> servers = new ArrayList<>();

        Server dev = new Server();
        dev.setUrl("http://localhost:8080");
        dev.setDescription("Servidor de desenvolvimento");

        Server hmg = new Server();
        hmg.setUrl("http://localhost:8080");
        hmg.setDescription("Servidor de produção");

        Server prod = new Server();
        prod.setUrl("http://localhost:8080");
        prod.setDescription("Servidor de homologação");

        servers.add(dev);
        servers.add(hmg);
        servers.add(prod);

        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Arquitetura Hexagonal")
                        .description("API para cadastro de usuário.")
                        .version(appVersion)
                        .termsOfService("https://smartbear.com/terms-of-use/")
                        .contact(contact)
                        .license(license)
                ).servers(servers);
    }

}
