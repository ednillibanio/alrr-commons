package br.kmdr.util.security;


public final class PasswordHash {

	public static String hashPassword(String login, String senha) {
		return org.jboss.security.auth.spi.Util.createPasswordHash("SHA-256", "BASE64", null, login, senha);
	}
	

}
