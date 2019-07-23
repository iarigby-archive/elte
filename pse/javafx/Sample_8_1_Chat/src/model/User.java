package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private byte[] password;

	private byte[] salt;
	
	public abstract boolean isBlocked();

	public User() {
	}

	public User(String name, byte[] password, byte[] salt) {
		this.name = name;
		this.password = password;
		this.salt = salt;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public byte[] getPassword() {
		return password;
	}

	public byte[] getSalt() {
		return salt;
	}

}
