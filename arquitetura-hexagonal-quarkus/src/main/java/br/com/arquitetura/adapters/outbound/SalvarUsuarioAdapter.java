package br.com.arquitetura.adapters.outbound;

import br.com.arquitetura.adapters.inbound.mapper.EnderecoMapper;
import br.com.arquitetura.adapters.inbound.mapper.UsuarioMapper;
import br.com.arquitetura.adapters.outbound.repository.UsuarioRepository;
import br.com.arquitetura.application.core.domain.Usuario;
import br.com.arquitetura.application.ports.out.SalvarUsuarioPort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class SalvarUsuarioAdapter implements SalvarUsuarioPort {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    EnderecoMapper enderecoMapper;

    @Inject
    UsuarioMapper mapper;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = mapper.toUsuarioEntity(usuario);
        var enderecoEntity = enderecoMapper.mapper(usuario.getEndereco());

        usuarioEntity.setEndereco(enderecoEntity);
        usuarioRepository.persist(usuarioEntity);

        return mapper.toUsuario(usuarioEntity);
    }
}
