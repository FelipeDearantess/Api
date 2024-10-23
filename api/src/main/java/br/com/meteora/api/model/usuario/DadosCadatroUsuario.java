package br.com.meteora.api.model.usuario;

import br.com.meteora.api.model.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;


public record DadosCadatroUsuario (

    @NotBlank
    String nome,

    @NotBlank
    String cpf,

    @NotNull
    String dataDeNascimento,

    @NotBlank @Email
    String email,

    @NotNull
    char genero,

    @NotNull @Valid
    DadosEndereco  endereco,

    @NotBlank
    String senha)
    {
}
