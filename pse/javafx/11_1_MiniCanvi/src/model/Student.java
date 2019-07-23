package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Student {
	
	@Id
	@TableGenerator(name = "Student_ID_Generator", table = "ID_GEN_TABLE", 
	pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE", 
	pkColumnValue = "Student_ID", initialValue = 1, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Student_ID_Generator")
	private int id;
	
	@Column(name = "Name", length = 128)
    private String name;
	
	@ManyToMany
	private Set<Assignment> assignments;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<AssignmentSolution> assignmentSolutions;
	
	public Student() {
		
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public void addOneMoreImpossibleAssignment(Assignment a) {
		Context.entityManager.getTransaction().begin();
		assignments.add(a);
		Context.entityManager.getTransaction().commit();
		
	}
	
	public Set<Assignment> getAssignments() {
		return assignments;
	}
	
	public void solve(Assignment a) {
		Context.entityManager.getTransaction().begin();
		assignmentSolutions.add(
			new AssignmentSolution(a, this, new Date())
		);
		assignments.remove(a);
		Context.entityManager.getTransaction().commit();
	}
}
