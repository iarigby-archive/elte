package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-28T14:22:50.582+0200")
@StaticMetamodel(Device.class)
public class Device_ {
	public static volatile SingularAttribute<Device, Integer> id;
	public static volatile SetAttribute<Device, UsageUGH> usages;
	public static volatile SingularAttribute<Device, String> brandName;
	public static volatile SingularAttribute<Device, String> operatingSystem;
	public static volatile SingularAttribute<Device, Boolean> isFree;
}
