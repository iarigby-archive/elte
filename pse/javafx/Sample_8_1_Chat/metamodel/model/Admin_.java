package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-10T17:56:48.535+0200")
@StaticMetamodel(Admin.class)
public class Admin_ extends User_ {
	public static volatile SetAttribute<Admin, Note> blockedNotes;
}
