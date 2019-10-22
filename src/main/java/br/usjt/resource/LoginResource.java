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

import br.usjt.model.Login;
import br.usjt.repository.LoginRepository;
import br.usjt.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginResource {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/listar")
	public List<Login> listar(){
		return loginRepository.findAll();
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Login> cadastrar(@RequestBody Login login, HttpServletResponse response){
		Login loginSalvo = loginRepository.save(login);
		return ResponseEntity.status(HttpStatus.CREATED).body(loginSalvo);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Login> atualizar(@PathVariable Long id,  @RequestBody Login login) throws Exception{
		Login loginSalvo = loginService.atualizar(id, login);
		return ResponseEntity.ok(loginSalvo);	
	}
	
	@DeleteMapping("/del/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		loginRepository.deleteById(id);
	}

}
