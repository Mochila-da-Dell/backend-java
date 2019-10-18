package br.usjt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.TokenMateria;
import br.usjt.repository.TokenMateriaRepository;

@Service
public class TokenMateriaService {
	
	@Autowired
	private TokenMateriaRepository tokenMateriaRepository;
	
	public TokenMateria buscarTokenId(Long id) throws Exception {
		TokenMateria tokenSalvo = tokenMateriaRepository.getOne(id);
		if (tokenSalvo == null) {
			throw new Exception();
		}
		return tokenSalvo;
	}
	
	public TokenMateria atualizar(Long id, TokenMateria token) throws Exception {
		TokenMateria tokenSalvo = buscarTokenId(id);

		BeanUtils.copyProperties(token, tokenSalvo, "id");
		return tokenMateriaRepository.save(tokenSalvo);
	}

}
