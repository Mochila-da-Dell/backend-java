package br.usjt.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.model.Aluno;
import br.usjt.model.Chamada;
import br.usjt.model.Materia;
import br.usjt.model.TokenChamada;
import br.usjt.repository.ChamadaRepository;
import br.usjt.repository.MateriaRepository;
import br.usjt.repository.TokenChamadaRepository;
import br.usjt.service.AlunoService;
import br.usjt.service.ChamadaService;
import br.usjt.service.MateriaService;

@CrossOrigin
@RestController
@RequestMapping("/chamada")
public class ChamadaResource {
	
	@Autowired
	private ChamadaRepository chamadaRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private TokenChamadaRepository tokenChamadaRepository;
	
	@Autowired
	private ChamadaService chamadaService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/listar")
	public List<Chamada> listar(){
		return chamadaRepository.findAll();
	}
	
	@GetMapping("/listar/faltas")
	public List<Chamada> listarFaltantes() {
		boolean presente = false;
		return chamadaRepository.findByPresente(presente);
	}
	
	@GetMapping("/listar/presentes")
	public List<Chamada> listarPresentes() {
		boolean presente = true;
		return chamadaRepository.findByPresente(presente);
	}
	
	@PostMapping("/presente/{token}")
	public ResponseEntity presente(@PathVariable String token, @RequestBody Chamada chamada, HttpServletResponse response) throws Exception{
		
		TokenChamada tokenChamada = tokenChamadaRepository.findByToken(token);
		
		System.out.println("tokennnnnn: " + tokenChamada.isAtivo());
		
		if (tokenChamada.isAtivo() == true) {
			
			Materia materia = materiaRepository.findByNome(chamada.getMateria().getNome());
			Aluno aluno = alunoService.buscarAlunoPorId(chamada.getAluno().getId());
			
			chamada.setMateria(materia);
			chamada.setAluno(aluno);
			
			boolean presente = true;
			
			chamada.setPresente(presente);
			
			Chamada chamadaSalva = chamadaRepository.save(chamada);
			return ResponseEntity.status(HttpStatus.CREATED).body(chamadaSalva);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
		}
		
	}
	
	@PostMapping("/falta")
	public ResponseEntity falta(@RequestBody Chamada chamada, HttpServletResponse response) throws Exception{
	
			Materia materia = materiaRepository.findByNome(chamada.getMateria().getNome());
			Aluno aluno = alunoService.buscarAlunoPorId(chamada.getAluno().getId());
			
			chamada.setMateria(materia);
			chamada.setAluno(aluno);
			
			boolean presente = false;
			
			chamada.setPresente(presente);
			
			Chamada chamadaSalva = chamadaRepository.save(chamada);
			return ResponseEntity.status(HttpStatus.CREATED).body(chamadaSalva);
		
	}
	
	
}
	
