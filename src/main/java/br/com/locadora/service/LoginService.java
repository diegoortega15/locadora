package br.com.locadora.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import br.com.locadora.model.Usuario;

public interface LoginService {

	public Usuario realizarLogin(String login, String senha);

	public Usuario realizarLoginGoogle(String login);

	public Usuario extractGoogleLoginInfo(String credential) throws GeneralSecurityException, IOException;

}