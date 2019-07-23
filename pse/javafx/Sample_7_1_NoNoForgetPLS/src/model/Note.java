package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Note {

    @Id
    @TableGenerator(name = "Note_ID_Generator", table = "ID_GEN_TABLE", 
        pkColumnName = "ID_NAME", valueColumnName = "NEXT_ID_GEN_SOURCE", 
        pkColumnValue = "Note_ID", initialValue = 1, allocationSize = 5)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Note_ID_Generator")
    private int id;

    @Column(length = 128)
    private String title;

    @Column(length = 512)
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    private City creator;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(unique = true, updatable = false)
    private Date date;

    private boolean isDone = false;

    public Note() {
    }

    public Note(String title, String content, City creator, Date date) {
        this.title = title;
        this.content = content;
        this.creator = creator;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public City getCreator() {
        return creator;
    }

    public Date getDate() {
        return date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

}
