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

import br.usjt.model.Materia;
import br.usjt.repository.MateriaRepository;
import br.usjt.service.MateriaService;

@RestController
@RequestMapping("/materia")
public class MateriaResource {
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@GetMapping
	public List<Materia> listar(){
		return materiaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Materia> criar(@RequestBody Materia materia, HttpServletResponse response){
		Materia materiaSalva = materiaRepository.save(materia);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(materiaSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Materia> atualizar (@PathVariable Long id, @RequestBody Materia materia) throws Exception{
		Materia materiaSalva = materiaService.atualizar(id, materia);
		return ResponseEntity.ok(materiaSalva);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id){
	  materiaRepository.deleteById(id);
	}
}
