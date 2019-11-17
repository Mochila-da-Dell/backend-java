package br.usjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.repository.TokenChamadaRepository;

@Service
public class TokenChamadaService {
	
	@Autowired
	private TokenChamadaRepository tokenChamadaRepository;
	
	public void atualizar(String token) throws Exception {
		
		boolean ativo = false;
		tokenChamadaRepository.updateTokenFlag(ativo, token);
	}
	

}
