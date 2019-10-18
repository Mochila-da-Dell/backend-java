package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
