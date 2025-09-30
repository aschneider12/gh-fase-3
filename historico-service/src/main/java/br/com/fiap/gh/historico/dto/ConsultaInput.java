package br.com.fiap.gh.historico.dto;

public record ConsultaInput(
        String dataConsulta,
        Long pacienteId,
        Long medicoId
) {
}
