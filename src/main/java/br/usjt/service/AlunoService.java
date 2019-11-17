package br.usjt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Aluno;
import br.usjt.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno buscarAlunoPorId(Long id) throws Exception {
		Aluno alunoSalvo = alunoRepository.getOne(id);
		if (alunoSalvo == null) {
			throw new Exception();
		}
		return alunoSalvo;
	}
	
	public Aluno atualizar(Long id, Aluno aluno) throws Exception {
		Aluno alunoSalvo = buscarAlunoPorId(id);

		BeanUtils.copyProperties(aluno, alunoSalvo, "id");
		return alunoRepository.save(alunoSalvo);
	}
	
	public boolean logar(Aluno aluno) {
		return alunoRepository.findOneByEmailAndSenha(aluno.getEmail(), aluno.getSenha()) != null;
	}
}

