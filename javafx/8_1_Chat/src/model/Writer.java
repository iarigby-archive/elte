package model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Writer extends User{
	
	@OneToMany(mappedBy = "creator")
	private Set<Note> notes;
	
	public Writer() {
		
	}

	public Writer(String name, byte[] password, byte[] salt) {
		super(name, password, salt);
	}
	
	public void addNote(Note note) {
		notes.add(note);
		note.setCreator(this);
	}
	public Set<Note> getNotes() {
		return notes;
	}
	
	
}
