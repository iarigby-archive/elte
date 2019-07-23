package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Creator")
public class City {

    @Id
    @TableGenerator(name = "Person_ID_Generator", table = "ID_GEN_TABLE", 
        pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE", 
        pkColumnValue = "Person_ID", initialValue = 1, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Person_ID_Generator")
    private int id;

    @Column(name = "Full_Name", length = 128)
    private String name;

    @OneToMany(mappedBy = "creator")
    private Set<Note> notes;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Note> getNotes() {
        return notes;
    }

}
