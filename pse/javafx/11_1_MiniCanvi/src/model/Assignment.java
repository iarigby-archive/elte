package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Assignment {
	
	@Id
	@TableGenerator(name = "Assignment_ID_Generator", table = "ID_GEN_TABLE", 
	pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE", 
	pkColumnValue = "Assignment_ID", initialValue = 1, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Assignment_ID_Generator")
	private int id;
	
	@Column(name = "Name", length = 128)
	private String name;
	
	@OneToMany(mappedBy = "assignment")
	private List<AssignmentSolution> assignmentSolutions;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date dueDate;
	
	public Assignment() {
		
	}
	
	public Assignment(String name, Date deadline) {
		this.name = name;
		this.dueDate = deadline;
	}
	
	public List<AssignmentSolution> getSolutions() {
		return assignmentSolutions;
	}

	public Date getDueDate() {
		return dueDate;
	}
	
	
}
