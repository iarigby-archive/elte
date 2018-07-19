package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "creator")
public class Person {
	
	@Id
	@TableGenerator(name = "Person_ID_Generator", table = "ID_table",
			pkColumnName = "ID_NAME", valueColumnName = "LAST_ID",
			pkColumnValue = "Person_ID", initialValue = 1, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Person_ID_Generator")
	
	private int id;
	
	private String name;
	
	public Person() {
		
	}	
	public Person(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}
