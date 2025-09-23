package br.com.fiap.gh.historico.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime data;

    public Consulta() {}

    public Consulta(Long pacienteId, Long medicoId, LocalDateTime data) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.data = data;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public Long getMedicoId() { return medicoId; }
    public void setMedicoId(Long medicoId) { this.medicoId = medicoId; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
}
