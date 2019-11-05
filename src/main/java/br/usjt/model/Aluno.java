package br.usjt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max =100)
	private String nome;
	
	@NotNull
	@Size(min=6, max= 15)
	private String ra;
	
	@NotNull
	@Size(min = 3, max =30)
	private String email;
	
	@NotNull
	@Size(min = 3, max = 15)
	private String senha;

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

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Aluno(Long id, @NotNull @Size(min = 3, max = 100) String nome, @NotNull @Size(min = 6, max = 15) String ra,
			@NotNull @Size(min = 3, max = 30) String email, @NotNull @Size(min = 3, max = 15) String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.ra = ra;
		this.email = email;
		this.senha = senha;
	}

	
	public Aluno() {
		
	}
	
}
