package com.example.tradejournal_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class TradingJournalGUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = Paths.get("./src/main/resources/com/example/tradejournal_fx/TradingJournalGUI.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Trading Journal");
        primaryStage.setScene(new Scene(root, 683, 345));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}