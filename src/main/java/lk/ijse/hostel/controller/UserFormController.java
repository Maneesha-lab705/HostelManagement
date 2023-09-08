package lk.ijse.hostel.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.hostel.Dto.UserDTO;
import lk.ijse.hostel.bo.custom.UserBO;
import lk.ijse.hostel.bo.custom.impl.UserBOImpl;

import java.io.IOException;

public class UserFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUseeName;

    UserBO userBO =new UserBOImpl();

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    void UserOnAction(ActionEvent event) {
        txtPassword.requestFocus();

    }

    @FXML
    void createonAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Loging_From.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }
    private void handleMousePressed(MouseEvent mouseEvent) {
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();

    }

    private void handleMouseDragged(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setX(mouseEvent.getScreenX() - xOffset);
        stage.setY(mouseEvent.getScreenY() - yOffset);
    }

    @FXML
    void passwordOnAction(ActionEvent event) {

    }

    public void SaveOnACtion(ActionEvent actionEvent) {
        String userName=txtUseeName.getText();
        String password =txtPassword.getText();

        UserDTO userDTO=new UserDTO(userName,password);
        boolean issave=userBO.save(userDTO);
        if (issave){
            new Alert(Alert.AlertType.CONFIRMATION,"User Is Save").show();
        }
    }
}
