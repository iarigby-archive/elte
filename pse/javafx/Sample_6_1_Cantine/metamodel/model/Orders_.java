package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-20T11:29:18.689+0100")
@StaticMetamodel(Orders.class)
public class Orders_ {
	public static volatile SingularAttribute<Orders, Integer> id;
	public static volatile SingularAttribute<Orders, Customer> customer;
	public static volatile SingularAttribute<Orders, Menu> menu;
	public static volatile SingularAttribute<Orders, Date> date;
}
