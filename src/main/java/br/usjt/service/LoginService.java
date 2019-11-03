package br.usjt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.model.Login;
import br.usjt.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public Login atualizar(Long id, Login login) throws Exception {
		Login loginSalvo = buscarLoginPorId(id);

		BeanUtils.copyProperties(login, loginSalvo, "id");
		return loginRepository.save(loginSalvo);
	}

	public Login buscarLoginPorId(Long id) throws Exception {
		Login loginSalvo = loginRepository.getOne(id);
		if (loginSalvo == null) {
			throw new Exception();
		}
		return loginSalvo;
	}
}
