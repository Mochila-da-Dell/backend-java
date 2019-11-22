package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Chamada;

public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
	
}
