package lk.ijse.hostel;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.hostel.controller.SplashScreenDemo;

import java.io.IOException;

public class Main extends Application {
    private double xOffset = 0;
    private double yOffset = 0;
    public static void main(String[] args) {
       // new SplashScreenDemo();
        launch(args);

    }
        @Override
    public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/view/LoadingPage.fxml"));
            Scene scene=new Scene(root);
            stage.setTitle("Login Page");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
//            root.setOnMousePressed(this::handleMousePressed);
//            root.setOnMouseDragged(this::handleMouseDragged);
            TranslateTransition transition = new TranslateTransition(Duration.seconds(1));
            transition.setFromX(root.getScene().getWidth());
            transition.setToX(0);
            stage.show();



    }

    public void start2(Stage stage) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("/view/Loging_From.fxml"));
        Scene scene =new Scene(load ) ;
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        load.setOnMousePressed(this::handleMousePressed);
        load.setOnMouseDragged(this::handleMouseDragged);
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1));
        transition.setFromX(load .getScene().getWidth());
        transition.setToX(0);
        stage.show();

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
}

