package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-08T19:09:46.877+0200")
@StaticMetamodel(Assignment.class)
public class Assignment_ {
	public static volatile SingularAttribute<Assignment, String> name;
	public static volatile ListAttribute<Assignment, AssignmentSolution> assignmentSolutions;
	public static volatile SingularAttribute<Assignment, Date> dueDate;
	public static volatile SingularAttribute<Assignment, Integer> id;
}
