package br.com.arquitetura.adapters.inbound.mapper;

import br.com.arquitetura.adapters.inbound.entity.EnderecoEntity;
import br.com.arquitetura.application.core.domain.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoEntity mapper(Endereco endereco);

}
