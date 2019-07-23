package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-10T17:56:22.255+0200")
@StaticMetamodel(Note.class)
public class Note_ {
	public static volatile SingularAttribute<Note, Integer> id;
	public static volatile SingularAttribute<Note, Admin> blockedBy;
}
