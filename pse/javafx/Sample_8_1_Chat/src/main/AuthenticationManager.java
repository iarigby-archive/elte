package main;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Admin;
import model.Writer;
import model.PasswordPair;
import model.User;
import model.User_;

public class AuthenticationManager {

	private static final SecureRandom RAND = new SecureRandom();

	private final EntityManager em;

	public AuthenticationManager(EntityManager em) {
		this.em = em;
	}

	public boolean authenticate(String username, char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> userQuery = cb.createQuery(User.class);
		Root<User> user = userQuery.from(User.class);
		userQuery.where(cb.equal(user.get(User_.name), username));
		userQuery.select(user);
		User u = em.createQuery(userQuery).getSingleResult();
		
		if (u.isBlocked()) {
			return false;
		} else {
			byte[] hash = hashPassword(password, u.getSalt());
			return constantTimeEquals(hash, u.getPassword());
		}
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
