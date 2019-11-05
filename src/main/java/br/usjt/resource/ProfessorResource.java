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

import br.usjt.model.Professor;
import br.usjt.repository.ProfessorRepository;
import br.usjt.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private ProfessorService professorService;
	
	/*@Autowired
	private LoginService loginService;*/
	
	@GetMapping("/listar")
	public List<Professor> listar(){
		return professorRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Professor listarUm(@PathVariable Long id) throws Exception{
		return professorRepository.getOne(id);
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Professor> cadastrar(@RequestBody Professor professor, HttpServletResponse response) throws Exception{
		
		//Login login = loginService.buscarLoginPorId(professor.getLogin().getId());
		//professor.setLogin(login);
		Professor professorSalvo = professorRepository.save(professor);
		return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Professor> atualizar(@PathVariable Long id,  @RequestBody Professor professor) throws Exception{
		Professor professorSalvo = professorService.atualizar(id, professor);
		return ResponseEntity.ok(professorSalvo);	
	}
	
	@DeleteMapping("/del/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}
}
