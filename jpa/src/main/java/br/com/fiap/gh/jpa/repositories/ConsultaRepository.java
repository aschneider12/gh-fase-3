package br.com.fiap.gh.jpa.repositories;

import br.com.fiap.gh.jpa.entities.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

    List<ConsultaEntity> findByPacienteId(Long pacienteId);

    List<ConsultaEntity> findByMedicoId(Long pacienteId);

    List<ConsultaEntity> findByDataAfter(LocalDateTime data);

    List<ConsultaEntity> findByMedicoIdAndDataAfter(Long medicoId, LocalDateTime data);
    List<ConsultaEntity> findByPacienteIdAndDataAfter(Long pacienteId, LocalDateTime data);
}
