package controller;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;

public class MenuController implements Initializable {

    private EntityManagerFactory emfactory;
    private EntityManager entityManager;

    @FXML
    private MenuBar menuBar;

    @FXML
    private Pane content;

    @Override
    public void initialize(java.net.URL arg0, ResourceBundle arg1) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Budapest"));
        emfactory = Persistence.createEntityManagerFactory("NoNoForget_PU");
        entityManager = emfactory.createEntityManager();
        Context.getInstance().setEntityManager(entityManager);
        menuBar.setFocusTraversable(true);
        createNewPage();
    }

    @FXML
    private void createListNotesPage() {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("../view/ListAllNotesMenu.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void createNewPage() {
        content.getChildren().clear();
        try {
            content.getChildren().add(FXMLLoader.load(getClass().getResource("../view/NewNoteForm.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void createListPeoplePage() {
        content.getChildren().clear();
        content.getChildren().add(new Label("Oh, no, this is your task, pal :/"));
    }

}