package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
