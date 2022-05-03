package br.com.arquitetura.application.core.usercase;

import br.com.arquitetura.application.core.domain.Endereco;
import br.com.arquitetura.application.core.domain.Usuario;
import br.com.arquitetura.application.ports.in.SalvarUsuarioServicePort;
import br.com.arquitetura.application.ports.out.BuscarEnderecoPort;
import br.com.arquitetura.application.ports.out.SalvarUsuarioPort;

public class SalvarUsuarioService implements SalvarUsuarioServicePort {

    private final SalvarUsuarioPort salvarUsuarioPort;
    private final BuscarEnderecoPort buscarEnderecoPort;

    public SalvarUsuarioService(SalvarUsuarioPort salvarUsuarioPortOut, BuscarEnderecoPort buscarEnderecoPortOut) {
        this.salvarUsuarioPort = salvarUsuarioPortOut;
        this.buscarEnderecoPort = buscarEnderecoPortOut;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario, String cep) {
        Endereco endereco = buscarEnderecoPort.buscar(cep);
        usuario.setEndereco(endereco);
        return salvarUsuarioPort.salvar(usuario);
    }
}
