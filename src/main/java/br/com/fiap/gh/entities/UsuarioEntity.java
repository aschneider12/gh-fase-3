package br.com.fiap.gh.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String login;

    private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonManagedReference //json irá serializar os perfis
	private Set<UsuarioPerfilEntity> perfis;

	public UsuarioEntity() {
	}

	public UsuarioEntity(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<UsuarioPerfilEntity> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<UsuarioPerfilEntity> perfis) {
		this.perfis = perfis;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		UsuarioEntity that = (UsuarioEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
