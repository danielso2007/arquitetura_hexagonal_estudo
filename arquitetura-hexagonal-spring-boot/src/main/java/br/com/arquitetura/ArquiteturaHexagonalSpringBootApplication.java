package br.com.arquitetura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@ComponentScan(value = {"br.com.arquitetura.adapters", "br.com.arquitetura.commons"})
@SpringBootApplication
@EnableJpaRepositories({"br.com.arquitetura.adapters.outbound.repository"})
@EntityScan(basePackages = {"br.com.arquitetura.adapters.inbound.entity"})
public class ArquiteturaHexagonalSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(ArquiteturaHexagonalSpringBootApplication.class, args);
	}
}
