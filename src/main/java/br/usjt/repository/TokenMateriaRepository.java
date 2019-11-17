package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.usjt.model.TokenMateria;

public interface TokenMateriaRepository extends JpaRepository<TokenMateria, Long>{

	@Transactional
	@Modifying
	@Query("UPDATE TokenMateria tk SET tk.ativo = :ativo WHERE tk.token = :token")
	void updateTokenFlag(@Param("ativo") boolean ativo, @Param("token") String token);
	
}
