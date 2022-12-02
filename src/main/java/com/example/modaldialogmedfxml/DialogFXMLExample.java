package com.example.modaldialogmedfxml;

//
// Eksempel på brug af fxml-filer til en modal dialog.
// App. viser vinduet "Dialog", hvor der kan indtastes en email adr. og trykkes "indsend"
//

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DialogFXMLExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("DialogTest.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}