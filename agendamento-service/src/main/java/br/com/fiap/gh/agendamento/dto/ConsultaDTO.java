package br.com.fiap.gh.agendamento.dto;

public record ConsultaDTO(
        Long id,
        String dataConsulta,
        Long pacienteId,
        String pacienteNome,
        Long medicoId,
        String medicoNome
) {
}
