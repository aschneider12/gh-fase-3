package br.com.fiap.gh.agendamento.dto;

public record ConsultaUpdate(
        Long consultaId,
        String dataConsulta,
        Long pacienteId,
        Long medicoId
) {
}
