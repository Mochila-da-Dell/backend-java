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

import br.usjt.model.Aluno;
import br.usjt.repository.AlunoRepository;
import br.usjt.service.AlunoService;

@CrossOrigin
@RestController
@RequestMapping("/aluno")
public class AlunoResource {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	/*@Autowired
	private LoginService loginService;
	*/
	@GetMapping("/listar")
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Aluno listarUm(@PathVariable Long id) throws Exception{
		return alunoRepository.getOne(id);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno, HttpServletResponse response) throws Exception{
		/*Login login = aluno.getLogin();
		Login loginSalvo = loginService.buscarLoginPorId(login.getId());
		aluno.setLogin(loginSalvo);*/
		Aluno alunoSalvo = alunoRepository.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
	}

	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long id,  @RequestBody Aluno aluno) throws Exception{
		Aluno alunoSalvo = alunoService.atualizar(id, aluno);
		return ResponseEntity.ok(alunoSalvo);	
	}
	
	@DeleteMapping("/del/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}
	
	@PostMapping("/fazerLogin")
	public ResponseEntity<String> fazerLogin(@RequestBody Aluno aluno, HttpServletResponse response) throws Exception{
		
		//System.out.println("request " + request);
		System.out.println("aluno " + aluno.getEmail());
		
		if (alunoService.logar(aluno)) {
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"logado\"}");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"nao logado\"}");
		}
	}
}
