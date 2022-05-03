package br.com.arquitetura.adapters.inbound.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class UsuarioRequest {

    @Schema(description = "O nome do usuário", example = "Daniel")
    @NotNull(message = "O nome não pode ser nula")
    private String nome;
    @Schema(description = "O instagram do usuário", example = "@test_quarkus")
    @NotNull(message = "O instagram não pode ser nula")
    private String instagram;
    @Schema(description = "O CEP do endereço do usuário", example = "24230126")
    @NotNull(message = "O CEP não pode ser nula")
    private String cep;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
