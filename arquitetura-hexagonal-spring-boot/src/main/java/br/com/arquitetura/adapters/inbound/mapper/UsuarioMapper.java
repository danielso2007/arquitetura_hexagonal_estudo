package br.com.arquitetura.adapters.inbound.mapper;

import br.com.arquitetura.adapters.inbound.entity.UsuarioEntity;
import br.com.arquitetura.adapters.inbound.request.UsuarioRequest;
import br.com.arquitetura.application.core.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toUsuario(UsuarioEntity usuarioEntity);
    @Mapping(target = "endereco", ignore = true)
    @Mapping(target = "id", ignore = true)
    Usuario requestToUsuario(UsuarioRequest usuarioRequest);
    UsuarioEntity toUsuarioEntity(Usuario usuario);

}
