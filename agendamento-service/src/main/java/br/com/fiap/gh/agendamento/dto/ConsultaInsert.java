package br.com.fiap.gh.agendamento.dto;

public record ConsultaInsert(
        String dataConsulta,
        Long pacienteId,
        Long medicoId
) {
}
