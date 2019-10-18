package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.model.Login;

public interface LoginRepository extends JpaRepository<Login,Long> {

}
