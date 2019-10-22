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

import br.usjt.model.Universidade;
import br.usjt.repository.UniversidadeRepository;
import br.usjt.service.UniversidadeService;

@RestController
@RequestMapping("/universidade")
public class UniversidadeResource {
	
	@Autowired
	private UniversidadeService universidadeService;
	
	@Autowired
	private UniversidadeRepository universidadeRepository;
	
	@GetMapping("/listar")
	public List<Universidade> listar(){
		return universidadeService.listar();
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Universidade> cadastrar(@RequestBody Universidade universidade, HttpServletResponse response){
		Universidade universidadeSalva = universidadeRepository.save(universidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(universidadeSalva);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Universidade> atualizar(@PathVariable Long codigo,  @RequestBody Universidade universidade) throws Exception{
		Universidade universidadeSalva = universidadeService.atualizar(codigo, universidade);
		return ResponseEntity.ok(universidadeSalva);	
	}
	
	@DeleteMapping("/del/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		universidadeRepository.deleteById(id);
	}

}
