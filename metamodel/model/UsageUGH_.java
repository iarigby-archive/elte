package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-25T11:04:57.242+0200")
@StaticMetamodel(UsageUGH.class)
public class UsageUGH_ {
	
	public static volatile SingularAttribute<UsageUGH, Client> client;
	public static volatile SingularAttribute<UsageUGH, Device> device;
	public static volatile SingularAttribute<UsageUGH, Date> logInTime;
	public static volatile SingularAttribute<UsageUGH, Date> logOutTime;
	public static volatile SingularAttribute<UsageUGH, Float> bill;
	
}
