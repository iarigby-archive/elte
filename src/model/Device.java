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
public class Device {

	@Id
	@TableGenerator(name = "Device_ID_Generator", table = "ID_GEN_Table",
	pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE",
	pkColumnValue = "Device_ID", initialValue = 1, allocationSize = 5)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Device_ID_Generator")
	private int id;
	
	@OneToMany(mappedBy="device", cascade = CascadeType.ALL)
	private Set<UsageUGH> usages;
	
	@Column(length = 128)
	private String brandName;
	
	@Column(length = 156)
	private String operatingSystem;
	
	private boolean isFree;
	
	public Device() {
		
	}
	
	public Device(String brandName, String operatingSystem) {
		this.brandName = brandName;
		this.operatingSystem = operatingSystem;
		this.isFree = true;
	}

	public int getId() {
		return id;
	}


	public String getBrandName() {
		return brandName;
	}

	public boolean isFree() {
		return isFree;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	public Set<UsageUGH> getUsages() {
		return usages;
	}
	
	@Override
	public String toString() {
		return "" + id;
	}

}
