package lk.ijse.hostel.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import lk.ijse.hostel.bo.custom.LoginBO;
import lk.ijse.hostel.bo.custom.impl.LogingBOImpl;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogingFromController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    private double xOffset = 0;
    private double yOffset = 0;

    LoginBO loginBO =new LogingBOImpl();

    @FXML
    void btnLogingOnAction(ActionEvent event) throws IOException {
        String userName=txtUserName.getText();
        String password=txtPassword.getText();

        boolean isConform=loginBO.serch(userName,password);
        System.out.println(isConform);
        if (isConform){
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashBord.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        }if (!isConform){
            new Alert(Alert.AlertType.ERROR,"WRONG USER OR PASSWORD!").show();
            txtPassword.setText("");
            txtUserName.setText("");
        }

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
    void btnCloseOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/DashBord.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login form");
        stage.centerOnScreen();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
     //createDatabase();
    }

    public void btncreateOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/User_Form.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("create account");
//        stage.initStyle(StageStyle.TRANSPARENT);
//        scene.setFill(Color.TRANSPARENT);
        stage.centerOnScreen();
    }

    public void userOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void passwordOnAction(ActionEvent actionEvent) throws IOException {
    }
//    private void createDatabase() {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//        transaction.commit();
//        session.close();
//    }
}
