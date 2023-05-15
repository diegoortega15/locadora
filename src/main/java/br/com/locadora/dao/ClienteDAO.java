package br.com.locadora.dao;

import java.time.LocalDateTime;
import java.util.List;

import br.com.locadora.model.Cliente;

public interface ClienteDAO {

	public void salvar(Cliente cliente);

	public List<Cliente> pesquisarClientes();

	public void deletar(Long idCliente);

	public Cliente pesquisarClientePorId(Long idCliente);

	public Cliente pesquisarClientePorLoginSenha(String login, String senhaMD5);

	public Cliente pesquisarClientePorLogin(String login);
	
	public Cliente pesquisarClientePorEmail(String email);

	public Cliente pesquisarClientePorCPF(String cpf);
	
	public List<Cliente> pesquisarClientesPorDataCadastro(LocalDateTime dataInicio, LocalDateTime dataFim);

}
