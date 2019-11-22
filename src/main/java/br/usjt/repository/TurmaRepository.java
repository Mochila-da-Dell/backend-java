package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	public Turma findByNome(String nome);

}
	