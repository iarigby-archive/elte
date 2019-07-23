package model;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
	
	public Admin() {
		
	}

	public Admin(String name, byte[] password, byte[] salt) {
		super(name, password, salt);
	}
	
}
