package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ImportantNote extends Note {

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deadLine;

    public ImportantNote() {
    }

    public ImportantNote(String title, String content, City creator, Date date, Priority priority, Date deadLine) {
        super(title, content, creator, date);
        this.priority = priority;
        this.deadLine = deadLine;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDeadLine() {
        return deadLine;
    }

}
