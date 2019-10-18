package br.usjt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Universidade;
import br.usjt.repository.UniversidadeRepository;

@Service
public class UniversidadeService {
	
	@Autowired
	private UniversidadeRepository universidadeRepository;
	
	public List<Universidade> listar(){
		return universidadeRepository.findAll();
	}
	
	public Universidade atualizar(Long id, Universidade universidade) throws Exception {
		Universidade universidadeSalva = buscarUniversidadeId(id);

		BeanUtils.copyProperties(universidade, universidadeRepository, "id");
		return universidadeRepository.save(universidadeSalva);
	}

	public Universidade buscarUniversidadeId(Long id) throws Exception {
		Universidade universidadeSalva = universidadeRepository.getOne(id);
		if (universidadeSalva == null) {
			throw new Exception();
		}
		return universidadeSalva;
	}
}	
