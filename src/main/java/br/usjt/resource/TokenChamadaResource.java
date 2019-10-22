package br.usjt.resource;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.model.TokenChamada;
import br.usjt.repository.TokenChamadaRepository;
import br.usjt.service.TokenChamadaService;

@RestController
@RequestMapping("/token-chamada")
public class TokenChamadaResource {
	
	@Autowired
	private TokenChamadaRepository tokenChamadaRepository;
	
	@Autowired
	private TokenChamadaService tokenChamadaService;
	
	/*
	@GetMapping
	public List<TokenChamada> listar(){
		return tokenChamadaRepository.findAll();
	}
	*/
	@PostMapping("/cadastrar")
	public ResponseEntity<TokenChamada> cadastrar( HttpServletResponse response){
		
		Random random = new Random();
		int numero = random.nextInt(10) * 1000000;
		
		String token = "CHM" + numero;
		System.out.println("eee::::::::::::::::::::::::::::::::" +token);
		
		boolean ativo = true;
		TokenChamada tokenChamada = new TokenChamada(token, ativo);
		TokenChamada tokenSalvo = tokenChamadaRepository.save(tokenChamada);
		return ResponseEntity.status(HttpStatus.CREATED).body(tokenSalvo);
	}
	
	/*
	@PutMapping("/atualizar/{codigo}")
	public ResponseEntity<TokenChamada> atualizar(@PathVariable Long id,  @RequestBody TokenChamada token) throws Exception{
		TokenChamada tokenSalvo = tokenChamadaService.atualizar(id, token);
		return ResponseEntity.ok(tokenSalvo);	
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		tokenChamadaRepository.deleteById(id);
	}
	*/
}
