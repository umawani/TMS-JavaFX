package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.au.edu.uts.ap.javafx.Controller;
import main.au.edu.uts.ap.javafx.ViewLoader;
import main.model.Faculty;
import main.model.Student;

import java.io.IOException;
import java.net.URISyntaxException;

public class StudentController extends Controller {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;
    @FXML private TextField studentIDField;
    @FXML private TextField typeField;
    @FXML private TextField creditsField;
    @FXML private TextField scholarshipField;
    @FXML private TextField deductionField;

    Validator validator;

    @FXML
    private void initialize(){
        validator = new Validator();
    }
    @FXML
    public void handleAdd(ActionEvent actionEvent) throws Exception {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        String studentID = studentIDField.getText();
        String type = typeField.getText();
        int credits = Integer.parseInt(creditsField.getText());
        double scholarship = Double.parseDouble(scholarshipField.getText());
        String deduction = deductionField.getText();

        boolean isValid = validator.isValid(name, email, phone, address, type, studentID, credits, scholarship);

        if(isValid){
            Faculty f = (Faculty) model;
            Student s = new Student(name, email, phone, address, studentID, type, credits, scholarship, deduction);
            f.addStudent(s);
            stage.close();
        }else{
            validator.generateErrors(name, email, phone, address, type, studentID, credits, scholarship);
            Stage errorStage = new Stage();
            errorStage.getIcons().add(new Image(FacultyController.class.getClassLoader().getResource("error.png").toURI().toString()));
            errorStage.setX(ViewLoader.X);
            errorStage.setY(ViewLoader.Y);
            ViewLoader.showStage(validator.errors(), "error.fxml", "Input Exceptions", errorStage);
            System.out.println(validator.errors().size());
        }
    }
    @FXML
    public void handleUpdate(ActionEvent actionEvent) {
    }
    @FXML
    public void handleClose(ActionEvent actionEvent) {
        stage.close();
    }
}
