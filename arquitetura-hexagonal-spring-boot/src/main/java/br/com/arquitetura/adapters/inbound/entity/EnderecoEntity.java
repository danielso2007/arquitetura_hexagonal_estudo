package br.com.arquitetura.adapters.inbound.entity;

import br.com.arquitetura.application.core.domain.Endereco;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "endereco", indexes = {@Index(name = "indexEnderecoCep", columnList = "cep")})
public class EnderecoEntity extends Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getCep() {
        return cep;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String getComplemento() {
        return complemento;
    }

    @Override
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String getBairro() {
        return bairro;
    }

    @Override
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String getLocalidade() {
        return localidade;
    }

    @Override
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @Override
    public String getUf() {
        return uf;
    }

    @Override
    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String getIbge() {
        return ibge;
    }

    @Override
    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    @Override
    public String getGia() {
        return gia;
    }

    @Override
    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String getDdd() {
        return ddd;
    }

    @Override
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Override
    public String getSiafi() {
        return siafi;
    }

    @Override
    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnderecoEntity)) return false;
        EnderecoEntity that = (EnderecoEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
