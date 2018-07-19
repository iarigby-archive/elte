package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class ImportantNote extends Note {
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;

	public Priority getPriority() {
		return priority;
	}

	public Date getDeadline() {
		return deadline;
	}
	
	public ImportantNote() {
		
	}

	public ImportantNote(String title, String content, Person creator, Date date, Priority priority, Date deadline) {
		super(title, content, creator, date);
		this.priority = priority;
		this.deadline = deadline;
	}
	
	
}
