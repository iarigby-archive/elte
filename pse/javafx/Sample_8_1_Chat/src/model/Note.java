package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@Entity
public class Note {

	@TableGenerator(name = "Note_ID_Generator", table = "ID_GEN_TABLE", 
		pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE", 
		pkColumnValue = "Note_ID", initialValue = 1, allocationSize = 5)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Note_ID_Generator")
	private int id;

	@ManyToOne
	private Admin blockedBy;

	public Note() {
	}
	
	public void setBlockedBy(Admin blockedBy) {
		this.blockedBy = blockedBy;
	}

	public int getId() {
		return id;
	}

	public boolean isBlocked() {
		return blockedBy != null;
	}

}
