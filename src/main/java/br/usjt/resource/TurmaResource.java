package br.usjt.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.model.Curso;
import br.usjt.model.Turma;
import br.usjt.model.Universidade;
import br.usjt.repository.TurmaRepository;
import br.usjt.service.CursoService;
import br.usjt.service.TurmaService;
import br.usjt.service.UniversidadeService;

@RestController
@RequestMapping("/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired 
	private UniversidadeService universidadeService;
	
	@Autowired
	private CursoService cursoService;

	@GetMapping("/listar")
	public List<Turma> listar(){
		return turmaRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Turma listarUm(@PathVariable Long id) throws Exception{
		return turmaRepository.getOne(id);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Turma> cadastrar(@RequestBody Turma turma, HttpServletResponse response) throws Exception{
		Universidade universidade = universidadeService.buscarUniversidadeId(turma.getUniversidade().getId());
		Curso curso = cursoService.buscarCursoId(turma.getCurso().getId());
		turma.setCurso(curso);
		turma.setUniversidade(universidade);
		Turma turmaSalva = turmaRepository.save(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(turmaSalva);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Turma> atualizar(@PathVariable Long id,  @RequestBody Turma turma) throws Exception{
		Turma turmaSalva = turmaService.atualizar(id, turma);
		return ResponseEntity.ok(turmaSalva);	
	}
	
	@DeleteMapping("/del/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		turmaRepository.deleteById(id);
	}
}

