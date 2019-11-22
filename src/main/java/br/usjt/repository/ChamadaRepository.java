package br.usjt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Chamada;

public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
	
	public List<Chamada> findByPresente(boolean presente);
	
}
