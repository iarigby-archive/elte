package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-25T11:04:57.242+0200")
@StaticMetamodel(ImportantNote.class)
public class ImportantNote_ extends Note_ {
	public static volatile SingularAttribute<ImportantNote, Priority> priority;
	public static volatile SingularAttribute<ImportantNote, Date> deadLine;
}
