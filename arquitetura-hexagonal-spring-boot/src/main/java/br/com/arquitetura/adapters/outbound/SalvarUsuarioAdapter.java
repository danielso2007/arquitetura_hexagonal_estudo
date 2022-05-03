package br.com.arquitetura.adapters.outbound;

import br.com.arquitetura.adapters.inbound.mapper.EnderecoMapper;
import br.com.arquitetura.adapters.inbound.mapper.UsuarioMapper;
import br.com.arquitetura.adapters.outbound.repository.UsuarioRepository;
import br.com.arquitetura.application.core.domain.Usuario;
import br.com.arquitetura.application.ports.out.SalvarUsuarioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SalvarUsuarioAdapter implements SalvarUsuarioPort {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private UsuarioMapper mapper;

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        var usuarioEntity = mapper.toUsuarioEntity(usuario);
        var enderecoEntity = enderecoMapper.mapper(usuario.getEndereco());

        usuarioEntity.setEndereco(enderecoEntity);
        usuarioRepository.save(usuarioEntity);

        return mapper.toUsuario(usuarioEntity);
    }
}
