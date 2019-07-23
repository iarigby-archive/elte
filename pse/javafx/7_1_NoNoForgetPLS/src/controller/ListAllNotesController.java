package controller;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sun.javafx.binding.ObjectConstant;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import model.ImportantNote;
import model.Note;
import model.Priority;

@SuppressWarnings("restriction")
public class ListAllNotesController implements Initializable {

    private final static String CRITICAL_STYLECLASS = "critical";
    private final static String MAJOR_STYLECLASS = "major";

    private EntityManager entityManager;

    @FXML
    private TableView<Note> tableView;

    @FXML
    private TableColumn<Note, String> firstNameColumn;

    @FXML
    private TableColumn<Note, String> creatorColumn;

    @FXML
    private TableColumn<Note, String> contentColumn;

    @FXML
    private TableColumn<Note, Date> deadlineColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        entityManager = Context.getInstance().getEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Note> allNotesQuery = cb.createQuery(Note.class);
        Root<Note> note = allNotesQuery.from(Note.class);
        allNotesQuery.select(note);
        List<Note> allNotes = entityManager.createQuery(allNotesQuery).getResultList();

        tableView.setItems(FXCollections.observableArrayList(allNotes));
        settingColumnContents();
        tableView.setRowFactory(tv -> {
            TableRow<Note> row = settingRowColor();
            settingRowOnClick(row);
            return row;
        });
    }

    void settingRowOnClick(TableRow<Note> row) {
        row.setOnMouseClicked(event -> {
            Note rowData = row.getItem();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Do anything with this note: " + rowData);

            alert.showAndWait();
        });
    }

    TableRow<Note> settingRowColor() {
        TableRow<Note> row = new TableRow<Note>() {
            @Override
            public void updateItem(Note item, boolean empty) {
                super.updateItem(item, empty);
                if (item instanceof ImportantNote) {
                    ImportantNote iNote = (ImportantNote) item;
                    getStyleClass()
                            .add(iNote.getPriority() == Priority.CRITICAL ? CRITICAL_STYLECLASS : MAJOR_STYLECLASS);
                } else {
                    getStyleClass().removeAll(CRITICAL_STYLECLASS, MAJOR_STYLECLASS);
                }
            }
        };
        return row;
    }

    void settingColumnContents() {
        creatorColumn.setCellValueFactory(new Callback<CellDataFeatures<Note, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Note, String> data) {
                return ObjectConstant.<String>valueOf(data.getValue().getCreator().getName());
            }
        });

        contentColumn.setCellValueFactory(new Callback<CellDataFeatures<Note, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Note, String> data) {
                return ObjectConstant.<String>valueOf(data.getValue().getContent().length() > 20
                        ? data.getValue().getContent().substring(0, 20) + "..."
                        : data.getValue().getContent());
            }
        });

        deadlineColumn.setCellValueFactory(new Callback<CellDataFeatures<Note, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(CellDataFeatures<Note, Date> data) {
                if (data.getValue() instanceof ImportantNote) {
                    return ObjectConstant.<Date>valueOf(((ImportantNote) data.getValue()).getDeadline());
                }
                return null;
            }
        });
    }

}
