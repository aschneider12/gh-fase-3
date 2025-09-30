package br.com.fiap.gh.agendamento.dto;

public record ConsultaInsertDTO(
        String dataConsulta,
        Long pacienteId,
        Long medicoId
) {
}
