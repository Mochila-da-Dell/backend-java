package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
