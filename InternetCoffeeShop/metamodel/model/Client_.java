package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-28T14:22:48.452+0200")
@StaticMetamodel(Client.class)
public class Client_ {
	public static volatile SingularAttribute<Client, Integer> id;
	public static volatile SingularAttribute<Client, String> name;
	public static volatile SingularAttribute<Client, String> address;
	public static volatile SingularAttribute<Client, String> personal_id;
	public static volatile SetAttribute<Client, UsageUGH> usages;
}
