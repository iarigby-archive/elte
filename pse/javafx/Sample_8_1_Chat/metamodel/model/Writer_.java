package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-10T17:54:59.932+0200")
@StaticMetamodel(Writer.class)
public class Writer_ extends User_ {
	public static volatile SetAttribute<Writer, Note> notes;
	public static volatile SingularAttribute<Writer, Admin> blockedBy;
}
