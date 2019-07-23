package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-04T17:50:42.200+0200")
@StaticMetamodel(Country.class)
public class Country_ {
	public static volatile SingularAttribute<Country, Integer> id;
	public static volatile SingularAttribute<Country, String> name;
	public static volatile SingularAttribute<Country, Continent> continent;
	public static volatile SetAttribute<Country, Language> languages;
	public static volatile SetAttribute<Country, City> cities;
}
