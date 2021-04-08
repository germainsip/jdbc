package org.ger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);

}

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("gui/tableau.fxml"));
        Scene scene = new Scene(root);
        System.out.println("ici");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}

