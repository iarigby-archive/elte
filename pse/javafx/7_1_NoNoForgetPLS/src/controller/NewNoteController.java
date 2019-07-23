package controller;

import java.net.URL;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.ImportantNote;
import model.Note;
import model.Person;
import model.Person_;
import model.Priority;

public class NewNoteController implements Initializable {

    private EntityManager entityManager;

    private Priority priority = null;

    @FXML
    private TextField title;

    @FXML
    private TextArea content;

    @FXML
    private TextField creator;

    @FXML
    private CheckBox major;

    @FXML
    private CheckBox critical;

    @FXML
    private VBox deadlineLabels;

    @FXML
    private VBox deadlines;

    @FXML
    private DatePicker date;

    @FXML
    private TextField time;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        entityManager = Context.getInstance().getEntityManager();
        date.setConverter(new DateConverter());
        deadlineLabels.setVisible(false);
        deadlines.setVisible(false);

        major.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (major.isSelected()) {
                    critical.setSelected(false);
                    priority = Priority.MAJOR;
                }
                boolean oneOfThemIsSelected = major.isSelected() || critical.isSelected();
                deadlineLabels.setVisible(oneOfThemIsSelected);
                deadlines.setVisible(oneOfThemIsSelected);
                if (!oneOfThemIsSelected) {
                    priority = null;
                }
            }
        });

        critical.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (critical.isSelected()) {
                    major.setSelected(false);
                    priority = Priority.CRITICAL;
                }
                boolean oneOfThemIsSelected = major.isSelected() || critical.isSelected();
                deadlineLabels.setVisible(oneOfThemIsSelected);
                deadlines.setVisible(oneOfThemIsSelected);
                if (!oneOfThemIsSelected) {
                    priority = null;
                }
            }
        });
    }

    public void createNote() {
        String creatorName = creator.getText();
        Person creator = searchForExistingCreator(creatorName);
        if (creator == null) {
            creator = new Person(creatorName);
        }

        Note note = null;
        if (priority == null) {
            note = new Note(title.getText(), content.getText(), creator, Date.from(ZonedDateTime.now().toInstant()));
        } else {
            Date deadline = Date.from(Instant.parse(date.getEditor().getText() + "T" + time.getText() + ":00Z"));
            note = new ImportantNote(title.getText(), content.getText(), creator,
                    Date.from(ZonedDateTime.now().toInstant()), priority, deadline);
        }

        entityManager.getTransaction().begin();
        entityManager.persist(note);
        entityManager.getTransaction().commit();
    }

    private Person searchForExistingCreator(String creatorName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> person = cq.from(Person.class);
        cq.where(person.get(Person_.name).in(creatorName));
        cq.select(person);
        List<Person> resultList = entityManager.createQuery(cq).getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

}
