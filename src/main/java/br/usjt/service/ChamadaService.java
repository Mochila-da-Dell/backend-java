package br.usjt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Chamada;
import br.usjt.repository.ChamadaRepository;

@Service
public class ChamadaService {
	
	@Autowired
	private ChamadaRepository chamadaRepository;
	
}
