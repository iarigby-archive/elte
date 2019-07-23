package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-20T11:29:18.689+0100")
@StaticMetamodel(Menu.class)
public class Menu_ {
	public static volatile SingularAttribute<Menu, Integer> id;
	public static volatile SingularAttribute<Menu, Day> day;
	public static volatile SingularAttribute<Menu, String> soup;
	public static volatile SingularAttribute<Menu, String> mainCourse;
	public static volatile SingularAttribute<Menu, String> dessert;
	public static volatile SingularAttribute<Menu, Integer> price;
}
