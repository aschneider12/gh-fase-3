package br.com.fiap.gh.historico.repositories;

import br.com.fiap.gh.historico.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByPacienteId(Long pacienteId);
    List<Consulta> findByDataAfter(LocalDateTime data);
}
