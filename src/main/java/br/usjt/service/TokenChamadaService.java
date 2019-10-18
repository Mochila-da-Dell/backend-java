package br.usjt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.TokenChamada;
import br.usjt.repository.TokenChamadaRepository;

@Service
public class TokenChamadaService {
	
	@Autowired
	private TokenChamadaRepository tokenChamadaRepository;
	
	public TokenChamada atualizar(Long id, TokenChamada token) throws Exception {
		TokenChamada tokenSalvo = buscarTokenId(id);

		BeanUtils.copyProperties(token, tokenSalvo, "id");
		return tokenChamadaRepository.save(tokenSalvo);
	}

	public TokenChamada buscarTokenId(Long id) throws Exception {
		TokenChamada tokenSalvo = tokenChamadaRepository.getOne(id);
		if (tokenSalvo == null) {
			throw new Exception();
		}
		return tokenSalvo;
	}


}
