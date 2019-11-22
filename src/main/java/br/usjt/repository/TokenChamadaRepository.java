package br.usjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.usjt.model.TokenChamada;

public interface TokenChamadaRepository extends JpaRepository<TokenChamada, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE TokenChamada tk SET tk.ativo = :ativo WHERE tk.token = :token")
	void updateTokenFlag(@Param("ativo") boolean ativo, @Param("token") String token);
	
	public TokenChamada findByToken(String token);

}
