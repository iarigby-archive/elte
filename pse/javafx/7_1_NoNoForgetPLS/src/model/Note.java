package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Note {
	@Id
	@TableGenerator(name = "Note_ID_Generator", table = "ID_table",
	pkColumnName = "ID_NAME", valueColumnName = "LAST_ID",
	pkColumnValue = "Note_ID", initialValue = 1, allocationSize = 3)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Note_ID_Generator")
	
	private int id;
	
	private String title;
	
	private String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Person creator;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(unique = true, updatable = false)
	private Date creationDate; 
	
	public Note() {
		
	}

	public Note(String title, String content, Person creator, java.util.Date date) {
		super();
		this.title = title;
		this.content = content;
		this.creator = creator;
		this.creationDate = date;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Person getCreator() {
		return creator;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	
}
