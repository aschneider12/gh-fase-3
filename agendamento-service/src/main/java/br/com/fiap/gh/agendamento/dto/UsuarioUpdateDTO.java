package br.com.fiap.gh.agendamento.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * No update o usuário só poderá atualizar alguns campos,
 * outros são tratados por controllers especificos, como senha e perfis
 *
 * @param nome
 * @param login
 */
public record UsuarioUpdateDTO(

    @NotBlank(message = "Nome não pode ser vazio.")
    String nome,
    @NotBlank(message = "Login não pode ser vazio.")
    String login
) { }


