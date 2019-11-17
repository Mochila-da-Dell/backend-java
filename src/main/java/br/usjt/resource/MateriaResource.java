package br.usjt.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.model.Materia;
import br.usjt.model.Professor;
import br.usjt.model.Turma;
import br.usjt.repository.MateriaRepository;
import br.usjt.service.MateriaService;
import br.usjt.service.ProfessorService;
import br.usjt.service.TurmaService;

@CrossOrigin
@RestController
@RequestMapping("/materia")
public class MateriaResource {
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired 
	private ProfessorService professorService;
	
	@GetMapping("/listar")
	public List<Materia> listar(){
		return materiaRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Materia listarUm(@PathVariable Long id) throws Exception{
		return materiaRepository.getOne(id);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Materia> criar(@RequestBody Materia materia, HttpServletResponse response) throws Exception{
		Turma turma = turmaService.buscarTurmaId(materia.getTurma().getId());
		Professor professor = professorService.buscarProfessorId(materia.getProfessor().getId());
		
		materia.setTurma(turma);
		materia.setProfessor(professor);
		
		Materia materiaSalva = materiaRepository.save(materia);
		return ResponseEntity.status(HttpStatus.CREATED).body(materiaSalva);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Materia> atualizar (@PathVariable Long id, @RequestBody Materia materia) throws Exception{
		Materia materiaSalva = materiaService.atualizar(id, materia);
		return ResponseEntity.ok(materiaSalva);
	}
	
	@DeleteMapping("del/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id){
	  materiaRepository.deleteById(id);
	}
}
