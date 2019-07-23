package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-08T18:53:08.369+0200")
@StaticMetamodel(AssignmentSolution.class)
public class AssignmentSolution_ {
	public static volatile SingularAttribute<AssignmentSolution, Integer> id;
	public static volatile SingularAttribute<AssignmentSolution, Assignment> assignment;
	public static volatile SingularAttribute<AssignmentSolution, Date> submissionDate;
	public static volatile SingularAttribute<AssignmentSolution, Boolean> checked;
	public static volatile SingularAttribute<AssignmentSolution, Student> student;
}
