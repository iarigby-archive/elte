package main;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.EntityManager;

import model.Admin;
import model.Writer;
import model.PasswordPair;

public class AuthenticationManager {

	private static final SecureRandom RAND = new SecureRandom();

	private final EntityManager em;

	public AuthenticationManager(EntityManager em) {
		this.em = em;
	}

	public boolean authenticate(String username, char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		// IMPLEMENT THIS METHOD
		// TODO
		return false;
	}

	public Admin registerAdmin(String name, char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PasswordPair p = hashPassword(password);
		return new Admin(name, p.getPassword(), p.getSalt());
	}

	public Writer registerWriter(String name, char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PasswordPair p = hashPassword(password);
		return new Writer(name, p.getPassword(), p.getSalt());
	}

	public byte[] hashPassword(char[] password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		PBEKeySpec spec = new PBEKeySpec(password, salt, 2000, 256);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		return skf.generateSecret(spec).getEncoded();
	}

	private boolean constantTimeEquals(byte[] a, byte[] b) {
		if (a.length != b.length) {
			return false;
		}

		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result |= a[i] ^ b[i];
		}

		return result == 0;
	}

	private PasswordPair hashPassword(char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		byte[] salt = new byte[256];
		RAND.nextBytes(salt);
		return new PasswordPair(hashPassword(password, salt), salt);
	}
}
