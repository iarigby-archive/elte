package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Writer extends User {

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Note> notes = new HashSet<>();

	@ManyToOne
	private Admin blockedBy;

	public Writer() {
	}

	public Writer(String name, byte[] password, byte[] salt) {
		super(name, password, salt);
	}

	public void addNote(Note note) {
		if (notes.size() < 5) {
			notes.add(note);
		}
	}

	public void setBlockedBy(Admin admin) {
		this.blockedBy = admin;
		for (Note r : notes) {
			r.setBlockedBy(admin);
		}
	}

	public Set<Note> getNotes() {
		return notes;
	}

	public Admin getBlockedBy() {
		return blockedBy;
	}

	@Override
	public boolean isBlocked() {
		return blockedBy != null;
	}

}
