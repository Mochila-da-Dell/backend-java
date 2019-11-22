package br.usjt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="chamada")
public class Chamada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	@NotNull
	private boolean presente;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_aluno")
	private Aluno aluno;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_materia")
	private Materia materia;

	public Chamada(Long id, @NotNull Date data, @NotNull boolean presente, @NotNull Aluno aluno, @NotNull Materia materia) {
		super();
		this.id = id;
		this.data = data;
		this.presente = presente;
		this.aluno = aluno;
		this.materia = materia;
	}
	
	public Chamada() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	

	public boolean getPresente() {
		return presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}
	

}
