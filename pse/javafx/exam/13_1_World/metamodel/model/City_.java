package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-04T17:33:15.304+0200")
@StaticMetamodel(City.class)
public class City_ {
	public static volatile SingularAttribute<City, String> name;
	public static volatile SingularAttribute<City, Integer> population;
	public static volatile SingularAttribute<City, Country> country;
}
