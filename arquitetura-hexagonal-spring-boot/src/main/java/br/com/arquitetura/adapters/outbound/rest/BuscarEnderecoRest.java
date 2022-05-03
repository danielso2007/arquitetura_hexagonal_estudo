package br.com.arquitetura.adapters.outbound.rest;

import br.com.arquitetura.application.core.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "buscaCep", url = "https://viacep.com.br")
public interface BuscarEnderecoRest {

    @GetMapping("/ws/{cep}/json")
//    @RequestMapping(method = RequestMethod.GET, value = "/ws/{cep}/json")
    Endereco buscar(@PathVariable("cep") String cep);
}
