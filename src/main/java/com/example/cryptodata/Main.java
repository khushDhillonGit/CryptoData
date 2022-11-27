package com.example.cryptodata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("coin-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image icon = new Image(getClass().getResourceAsStream("images/logo.jpg"));
        stage.getIcons().add(icon);

        stage.setTitle("Search Coin!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        launch();
    }
}