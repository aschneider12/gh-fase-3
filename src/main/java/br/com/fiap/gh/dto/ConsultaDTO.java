package br.com.fiap.gh.dto;

public record ConsultaDTO(
        Long paciente_id,
        Long medico_id,
        String data
) {
}
