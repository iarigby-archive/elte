package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-25T11:04:57.242+0200")
@StaticMetamodel(Device.class)
public class Device_ {
	
	public static volatile SingularAttribute<Device, Client> owner;
	public static volatile SingularAttribute<Device, String> brandName;
	public static volatile SingularAttribute<Device, String> operatingSystem;
	public static volatile SingularAttribute<Device, Boolean> isFree;

}
