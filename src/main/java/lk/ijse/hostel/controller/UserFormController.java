package lk.ijse.hostel.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserFormController {

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUseeName;

    @FXML
    void UserOnAction(ActionEvent event) {
        txtPassword.requestFocus();

    }

    @FXML
    void createonAction(ActionEvent event) {

    }

    @FXML
    void passwordOnAction(ActionEvent event) {
    }

    public void SaveOnACtion(ActionEvent actionEvent) {
    }
}
