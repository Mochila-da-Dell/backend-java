package br.usjt.resource;

import java.util.List;
import java.util.Random;

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

import br.usjt.model.TokenMateria;
import br.usjt.repository.TokenMateriaRepository;
import br.usjt.service.TokenMateriaService;

@RestController
@RequestMapping("/token-materia")
public class TokenMateriaResource {
	
	@Autowired
	private TokenMateriaService tokenMateriaService;
	
	@Autowired
	private TokenMateriaRepository tokenMateriaRepository;
	
	/*
	@GetMapping
	public List<TokenMateria> listar(){
		return tokenMateriaRepository.findAll();
	}
	*/
	
	@PostMapping("/cadastrar/{id}")
	public ResponseEntity<TokenMateria> criar(@PathVariable Long id, HttpServletResponse response){
		
		Random random = new Random();
		int numero = random.nextInt(10) * 1000000;
		
		String token = "MAT" + numero;
		System.out.println("eee::::::::::::::::::::::::::::::::" +token);

		boolean ativo = true;
		TokenMateria tokenMateria = new TokenMateria(token, ativo, id); //id materia
		
		
		TokenMateria tokenSalvo = tokenMateriaRepository.save(tokenMateria);
		return ResponseEntity.status(HttpStatus.CREATED).body(tokenSalvo);
//	}
	
	/*
	@PutMapping("/atualizar/{codigo}")
	public ResponseEntity<TokenMateria> atualizar(@PathVariable Long id,  @RequestBody TokenMateria token) throws Exception{
		TokenMateria tokenSalvo = tokenMateriaService.atualizar(id, token);
		return ResponseEntity.ok(tokenSalvo);	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		tokenMateriaRepository.deleteById(id);
	}
	
	*/

}
