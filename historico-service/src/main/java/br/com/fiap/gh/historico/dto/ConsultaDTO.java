package br.com.fiap.gh.historico.dto;

import br.com.fiap.gh.jpa.entities.ConsultaEntity;

import java.util.List;

public record ConsultaDTO(
        Long id,
//        String especialidade,
        String dataConsulta,
        Long pacienteId,
        String pacienteNome,
        Long medicoId,
        String medicoNome
) {

    public static ConsultaDTO fromEntity(ConsultaEntity c) {

        return new ConsultaDTO(c.getId(),c.getData().toString(), c.getPaciente().getId(), c.getPaciente().getNome(),
                c.getMedico().getId(), c.getMedico().getNome());
    }

    public static List<ConsultaDTO> fromEntity(List<ConsultaEntity> minhasConsultas) {

        return minhasConsultas.stream().map(ConsultaDTO::fromEntity).toList();
    }
}
