package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-05-28T16:06:04.449+0200")
@StaticMetamodel(UsageUGH.class)
public class UsageUGH_ {
	public static volatile SingularAttribute<UsageUGH, Integer> id;
	public static volatile SingularAttribute<UsageUGH, Client> client;
	public static volatile SingularAttribute<UsageUGH, Device> device;
	public static volatile SingularAttribute<UsageUGH, Date> logInTime;
	public static volatile SingularAttribute<UsageUGH, Date> logOutTime;
	public static volatile SingularAttribute<UsageUGH, Float> bill;
}
