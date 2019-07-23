package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Client {
	
	@Id
	@TableGenerator(name = "Client_ID_Generator", table = "ID_GEN_Table",
	pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE",
	pkColumnValue = "Client_ID", initialValue = 1, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Client_ID_Generator")
	private int id;
	
	@Column(name = "Full_Name", length = 128)
	private String name;
	
	@Column(name = "Address", length = 256)
	private String address;
	
	@Column(name = "Personal_ID", length = 128)
	private String personal_id;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<UsageUGH> usages;
	
	
	public Client() {
		
	}
	
	public Client(String name, String address, String personal_id) {
		this.name = name;
		this.address = address;
		this.personal_id = personal_id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPersonal_id() {
		return personal_id;
	}

	public Set<UsageUGH> getUsages() {
		return usages;
	}

	public Client setName(String name) {
		this.name = name;
		return this;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPersonal_id(String personal_id) {
		this.personal_id = personal_id;
	}
	
	@Override
	public String toString() {
		return "" + id;
	}

	
	
	
}
