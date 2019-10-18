package br.usjt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Turma;
import br.usjt.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public Turma atualizar(Long id, Turma turma) throws Exception {
		Turma turmaSalvo = buscarTurmaId(id);

		BeanUtils.copyProperties(turma, turmaSalvo, "id");
		return turmaRepository.save(turmaSalvo);
	}

	public Turma buscarTurmaId(Long id) throws Exception {
		Turma turmaSalvo = turmaRepository.getOne(id);
		if (turmaSalvo == null) {
			throw new Exception();
		}
		return turmaSalvo;
	}

}
