package com.example.buy;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FirstApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Java Journeys");
            Image icon = new Image(getClass().getResourceAsStream("logi.png"));
            stage.getIcons().add(icon);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();;
        }
    }
    //===========================================


    public static void main(String[] args){
        launch(args);
    }
}
