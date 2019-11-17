package br.usjt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Professor;
import br.usjt.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public Professor atualizar(Long id, Professor professor) throws Exception {
		Professor professorSalvo = buscarProfessorId(id);

		BeanUtils.copyProperties(professor, professorSalvo, "id");
		return professorRepository.save(professorSalvo);
	}
	public Professor buscarProfessorId(Long id) throws Exception {
		Professor professorSalvo = professorRepository.getOne(id);
		if (professorSalvo == null) {
			throw new Exception();
		}
		return professorSalvo;
	}

	public boolean logar(Professor professor) {
		return professorRepository.findOneByEmailAndSenha(professor.getEmail(), professor.getSenha()) != null;
	}
}
