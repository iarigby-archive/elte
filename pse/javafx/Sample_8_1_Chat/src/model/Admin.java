package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Admin extends User {

	@OneToMany(mappedBy = "blockedBy", cascade = CascadeType.ALL)
	private Set<Note> blockedNotes = new HashSet<>();

	public Admin() {
	}

	public Admin(String name, byte[] password, byte[] salt) {
		super(name, password, salt);
	}

	public Set<Note> getBlockedNotes() {
		return blockedNotes;
	}

	@Override
	public boolean isBlocked() {
		return false;
	}

}
