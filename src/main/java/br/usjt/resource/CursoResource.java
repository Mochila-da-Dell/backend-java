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
import br.usjt.repository.CursoRepository;
import br.usjt.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping("/listar")
	private List<Curso> listar(){
		return cursoService.listar();
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Curso> criar( @RequestBody Curso curso, HttpServletResponse response) {
		Curso cursoSalvo = cursoRepository.save(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
	}
	
	@PutMapping("/atualizar/{codigo}")
	public ResponseEntity<Curso> atualizar(@PathVariable Long id,  @RequestBody Curso curso) throws Exception{
		Curso cursoSalvo = cursoService.atualizar(id, curso);
		return ResponseEntity.ok(cursoSalvo);	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		cursoRepository.deleteById(id);
	}
}
