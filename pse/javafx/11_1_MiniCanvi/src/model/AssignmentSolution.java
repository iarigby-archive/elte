package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AssignmentSolution {
	
	@Id
	@TableGenerator(name = "AssignmentSolution_ID_Generator", table = "ID_GEN_TABLE", 
	pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE", 
	pkColumnValue = "AssignmentSolution_ID", initialValue = 1, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AssignmentSolution_ID_Generator")
	private int id;
	
	@ManyToOne
	private Assignment assignment;
	
	@ManyToOne
	private Student student;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date submissionDate;
	
	private Boolean checked;
	
	public AssignmentSolution() {
		
	}

	public AssignmentSolution(Assignment assignment, Student submitter, Date dateSubmitted) {
		this.assignment = assignment;
		this.student = submitter;
		this.submissionDate = dateSubmitted;
		this.checked = false;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}
	
	public Boolean isChecked() {
		return checked;
	}
	
	public void check() {
		checked = true;
	}
	

	
}
