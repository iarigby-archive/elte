package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-04T18:12:29.529+0200")
@StaticMetamodel(Language.class)
public class Language_ {
	public static volatile SingularAttribute<Language, Integer> id;
	public static volatile SingularAttribute<Language, String> name;
	public static volatile SetAttribute<Language, Country> countries;
}
