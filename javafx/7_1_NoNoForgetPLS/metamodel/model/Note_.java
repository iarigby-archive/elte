package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-27T22:31:44.079+0200")
@StaticMetamodel(Note.class)
public class Note_ {
	public static volatile SingularAttribute<Note, Integer> id;
	public static volatile SingularAttribute<Note, String> title;
	public static volatile SingularAttribute<Note, String> content;
	public static volatile SingularAttribute<Note, Person> creator;
	public static volatile SingularAttribute<Note, Date> creationDate;
}
