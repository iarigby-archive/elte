package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String name;
	
	private byte[] password;
	private byte[] salt;
	
	private boolean isBlocked = false;
	
	
	public User() {

	}
	
	public User(String name, byte[] password, byte[] salt) {
		this.name = name;
		this.password = password;
		this.salt = salt;
	}
	
	public void setBlockedBy(Admin admin) {
		isBlocked = true;
	}
	
	public boolean isBlocked() {
		return isBlocked;
	}
	
	
}
