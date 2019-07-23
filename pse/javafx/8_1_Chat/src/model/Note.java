package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note {
	@Id
	private int id;
	
	@ManyToOne
	private Writer creator;
	
	public Note() {
		
	}
	
	public void setCreator(Writer creator) {
		this.creator = creator;
	}
	public int getId() { return id;}
}
