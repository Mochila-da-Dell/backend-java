package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Universidade;

public interface UniversidadeRepository extends JpaRepository<Universidade, Long> {
	
}
