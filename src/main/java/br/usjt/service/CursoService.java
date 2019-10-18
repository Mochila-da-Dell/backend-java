package br.usjt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Curso;
import br.usjt.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	public Curso atualizar(Long id, Curso curso) throws Exception {
		Curso cursoSalvo = buscarCursoId(id);

		BeanUtils.copyProperties(curso, cursoSalvo, "id");
		return cursoRepository.save(cursoSalvo);
	}

	public Curso buscarCursoId(Long id) throws Exception {
		Curso cursoSalvo = cursoRepository.getOne(id);
		if (cursoSalvo == null) {
			throw new Exception();
		}
		return cursoSalvo;
	}
}
