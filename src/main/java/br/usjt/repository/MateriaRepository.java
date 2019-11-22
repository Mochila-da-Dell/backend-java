package br.usjt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
	
	public Materia findByNome(String nome);
}
