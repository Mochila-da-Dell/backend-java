package br.usjt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Materia;
import br.usjt.repository.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;

	public Materia atualizar(Long id, Materia materia) throws Exception {

		Materia materiaSalva = buscarMateriaPorId(id);
		BeanUtils.copyProperties(materia, materiaSalva, "id");
		return materiaRepository.save(materiaSalva);

	}

	public Materia buscarMateriaPorId(Long id) throws Exception {
		Materia materiaSalva = materiaRepository.getOne(id);
		if (materiaSalva == null) {
			throw new Exception();
		}
		return materiaSalva;
	}

}
