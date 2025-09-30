package br.com.fiap.gh.jpa.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "consulta")
public class ConsultaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@ManyToOne
	@JoinColumn(name = "paciente_id", insertable = false, updatable = false)
	private UsuarioEntity paciente;

	@ManyToOne
	@JoinColumn(name = "medico_id", insertable = false, updatable = false)
    private UsuarioEntity medico;

	private LocalDateTime data;

	public ConsultaEntity() {
	}
	public ConsultaEntity(Long id) {
		this.id = id;
	}

    public ConsultaEntity(UsuarioEntity paciente, UsuarioEntity medico, LocalDateTime data) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(UsuarioEntity paciente) {
		this.paciente = paciente;
	}

	public UsuarioEntity getMedico() {
		return medico;
	}

	public void setMedico(UsuarioEntity medico) {
		this.medico = medico;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		ConsultaEntity that = (ConsultaEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
