package br.kmdr.util.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigesterHelper {

	public static String digest(String algoritimo, String objeto)
			throws NoSuchAlgorithmException {

		return digest(algoritimo, objeto.getBytes());
	}

	public static String digest(String algoritimo, byte[] objeto)
			throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance(algoritimo);
		byte[] b = md.digest(objeto);

		return HexUtils.convert(b);
	}

}
