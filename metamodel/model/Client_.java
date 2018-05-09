package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-25T11:04:57.242+0200")
@StaticMetamodel(Client.class)
public class Client_ {
	
	public static volatile SingularAttribute<Client, String> name;
	public static volatile SingularAttribute<Client, String> address;
	public static volatile SingularAttribute<Client, String> personal_id;
	public static volatile SetAttribute<Client, Device> devices;

}
