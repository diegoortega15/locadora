package br.com.locadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.locadora.dao.FuncionarioDAO;
import br.com.locadora.dao.PerfilDAO;
import br.com.locadora.model.Funcionario;
import br.com.locadora.model.Perfil;
import br.com.locadora.utils.SenhaUtils;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDAO funcionarioDAO;

	@Autowired
	private PerfilDAO perfilDAO;

	@Override
	@Transactional
	public void salvar(Funcionario funcionario) {
		Perfil perfil = perfilDAO.pesquisarPerfilPorId(funcionario.getPerfil().getId());
		funcionario.setPerfil(perfil);

		String senhaMD5 = SenhaUtils.convertStringToMd5(funcionario.getSenha());
		funcionario.setSenha(senhaMD5);
		
		funcionarioDAO.salvar(funcionario);
	}

	@Override
	@Transactional
	public List<Funcionario> pesquisarFuncionarios() {
		return funcionarioDAO.pesquisarFuncionarios();
	}

	@Override
	@Transactional
	public void deletar(Long idFuncionario) {
		funcionarioDAO.deletar(idFuncionario);
	}

	@Override
	@Transactional
	public Funcionario pesquisarFuncionarioPorId(Long idFuncionario) {
		return funcionarioDAO.pesquisarFuncionarioPorId(idFuncionario);
	}

	@Override
	@Transactional
	public Funcionario pesquisarFuncionarioPorLoginSenha(String login, String senha) {
		String senhaMD5 = SenhaUtils.convertStringToMd5(senha);
		return funcionarioDAO.pesquisarFuncionarioPorLoginSenha(login, senhaMD5);
	}

	@Override
	@Transactional
	public void alterarSenha(Long idFuncionario, String senha) {
		Funcionario funcionario = pesquisarFuncionarioPorId(idFuncionario);
		funcionario.setSenha(SenhaUtils.convertStringToMd5(senha));
		this.funcionarioDAO.salvar(funcionario);

	}

	@Override
	@Transactional
	public void atualizarDados(Funcionario funcionario) {

		Funcionario funcionarioBD = pesquisarFuncionarioPorId(funcionario.getId());

		funcionario.setLogin(funcionarioBD.getLogin());
		funcionario.setSenha(funcionarioBD.getSenha());
		funcionario.setPerfil(funcionarioBD.getPerfil());

		this.funcionarioDAO.salvar(funcionario);

	}

	@Override
	@Transactional
	public Funcionario pesquisarFuncionarioPorCPF(String cpf) {
		return funcionarioDAO.pesquisarFuncionarioPorCPF(cpf);
	}

	@Override
	@Transactional
	public Funcionario pesquisarFuncionarioPorLogin(String login) {
		return funcionarioDAO.pesquisarFuncionarioPorLogin(login);
	}

	@Override
	@Transactional
	public Funcionario pesquisarFuncionarioPorEmail(String email) {
		return funcionarioDAO.pesquisarFuncionarioPorEmail(email);
	}

}