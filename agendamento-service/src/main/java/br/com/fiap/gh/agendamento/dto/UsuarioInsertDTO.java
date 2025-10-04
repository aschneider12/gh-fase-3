package br.com.fiap.gh.agendamento.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UsuarioInsertDTO(

    @NotBlank(message = "Nome não pode ser vazio.")
    String nome,

    @NotBlank(message = "Login não pode ser vazio.")
    String login,

    @NotBlank(message = "Email não pode ser vazia.")
    String email,

    @NotBlank(message = "Senha não pode ser vazia.")
    @Schema(description = "Senha com no mínimo 8 caracteres, incluindo letras e números.")
    String senha,


    @NotNull(message = "Perfil de usuário não pode ser nulo, pelo menos um tipo deve ser informado.")
    Set<String> perfis

) { }


