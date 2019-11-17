package br.usjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.repository.TokenMateriaRepository;

@Service
public class TokenMateriaService {
	
	@Autowired
	private TokenMateriaRepository tokenMateriaRepository;
	
	public void atualizar(String token) throws Exception {
		
		boolean ativo = false;
		tokenMateriaRepository.updateTokenFlag(ativo, token);
	}
}
