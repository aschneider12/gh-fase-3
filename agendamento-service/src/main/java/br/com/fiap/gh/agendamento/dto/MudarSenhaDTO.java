package br.com.fiap.gh.agendamento.dto;

import jakarta.validation.constraints.NotBlank;

public record MudarSenhaDTO(
        @NotBlank(message = "A senha antiga não pode estar em branco.")
        String senhaAntiga,

        @NotBlank(message = "A nova senha não pode estar em branco.")
        String senhaNova) {
}
