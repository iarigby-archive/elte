package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Entity
public class Teacher {
	
	@Id
	@TableGenerator(name = "Teacher_ID_Generator", table = "ID_GEN_TABLE", 
	pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE", 
	pkColumnValue = "Teacher_ID", initialValue = 1, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Teacher_ID_Generator")
	private int id;
	
	@Column(name = "Name", length = 128)
	private String name;
	
	public Teacher() {
		
	}
	
	public void checkAll() {
		CriteriaBuilder cb = Context.entityManager.getCriteriaBuilder();
        CriteriaQuery<AssignmentSolution> solutionQuery = cb.createQuery(AssignmentSolution.class);
        Root<AssignmentSolution> root = solutionQuery.from(AssignmentSolution.class);
        solutionQuery.where(
                cb.equal(root.get(AssignmentSolution_.checked), false)
        );
        List<AssignmentSolution> resultList = Context.entityManager.createQuery(solutionQuery).getResultList();
        Context.entityManager.getTransaction().begin();
        for (AssignmentSolution assignment : resultList) {
        	assignment.check();
        }
        Context.entityManager.getTransaction().commit();
	}
	
	
	public Teacher(String name) {
		this.name = name;
	}
}
