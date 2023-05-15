package br.com.locadora.service;

import java.util.List;

import br.com.locadora.model.Usuario;

public interface UsuarioService {

	public void salvar(Usuario usuario);

	public List<Usuario> pesquisarUsuarios();

	public void deletar(Long idUsuario);

	public Usuario pesquisarUsuarioPorId(Long idUsuario);

	public Usuario pesquisarUsuarioPorLoginSenha(String login, String senha);
	
	public void alterarSenha(Long idFuncionario, String senha);
	
	public void salvarExterno(Usuario usuario);
	
}