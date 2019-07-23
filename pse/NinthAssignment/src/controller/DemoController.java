/*
> %% Ia Mgvdliashvili
>
> %% OVQXYE
>
> %% Practical Software Engineering I , Ninth Assignment
>
> %% 2017.11.28
>
> %% This solution was submitted and prepared by Ia Mgvdliashvili , OVQXYE for the
> Ninth assignment of the Practical Software Engineering course.
>
> %% I declare that this solution is my own work.
>
> %% I have not copied or used third party solutions.
>
> %% I have not passed my solution to my classmates, neither  made it public.
>
> %% Students’ regulation of Eötvös Loránd University (ELTE Regulations
> Vol. II. 74/C. § ) states that as long as a student presents another
> student’s work - or at least the significant part of it - as his/her own
> performance, it will count as a disciplinary fault. The most serious

> consequence of a disciplinary fault can be dismissal of the student from
> the University."

*/

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;

public class DemoController implements Initializable {

    @FXML
    private GridPane loginPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    	
    	loginPane.add(new Label("Log In"), 1, 0);
    	
    	loginPane.add(new Label("username"), 0, 1);
    	loginPane.add(new TextField(), 1, 1);
    	loginPane.add(new Label("password"), 0, 2);
    	loginPane.add(new PasswordField(), 1, 2);
    	
    	
    	loginPane.add(new Button("log in"), 1, 4);
    	loginPane.add(new Button("register"), 2, 4);
    	
    
    }
}
