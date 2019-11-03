package br.usjt.resource;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.model.Materia;
import br.usjt.model.TokenMateria;
import br.usjt.repository.TokenMateriaRepository;
import br.usjt.service.MateriaService;

@RestController
@RequestMapping("/token-materia")
public class TokenMateriaResource {

	@Autowired
	private TokenMateriaRepository tokenMateriaRepository;

	@Autowired
	private MateriaService materiaService;

	@GetMapping("/listar")
	public List<TokenMateria> listar() {
		return tokenMateriaRepository.findAll();
	}

	@PostMapping("/cadastrar/{id}")
	public ResponseEntity<TokenMateria> criar(@PathVariable Long id, HttpServletResponse response) throws Exception {
		Random random = new Random();
		int numero = random.nextInt(10) * random.nextInt(700000);
		String token = "MAT" + numero;
		Materia materiaSalva = materiaService.buscarMateriaPorId(id);
		boolean ativo = true;
		TokenMateria tokenMateria = new TokenMateria(token, ativo, materiaSalva);
		TokenMateria tokenSalvo = tokenMateriaRepository.save(tokenMateria);
		return ResponseEntity.status(HttpStatus.CREATED).body(tokenSalvo);
	}
}
