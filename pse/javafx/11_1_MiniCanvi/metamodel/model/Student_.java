package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-08T18:51:30.524+0200")
@StaticMetamodel(Student.class)
public class Student_ {
	public static volatile SingularAttribute<Student, Integer> id;
	public static volatile SingularAttribute<Student, String> name;
	public static volatile SetAttribute<Student, Assignment> assignments;
	public static volatile SetAttribute<Student, AssignmentSolution> assignmentSolutions;
}
