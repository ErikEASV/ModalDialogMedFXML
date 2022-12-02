package com.example.modaldialogmedfxml;
import java.io.IOException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogTestController {
    // til at checke om en email er korrekt
    private final Pattern emailPattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9_]*@[a-zA-Z]+(\\.[a-zA-Z0-9_]+)*");

    @FXML
    private TextField emailField;

    // submit-knap har teksten "indsend"
    @FXML
    public void submit() throws IOException {
        // Teksten i feltet checkes som email adresse svares og der svares med et dialogvindue med passende tekst
        if (emailPattern.matcher(emailField.getText()).matches()) {
            showWindow("Thanks");
        } else {
            showWindow("Not a valid email address");
        }
    }

    // Her dannes dialogvinduet med egen fxml fil og controlleren sættes til "DialogController" klassen.
    private void showWindow(String message) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("Dialog.fxml"));
        loader.setController(new DialogController(message));
        // Root loades og den nye stage tilføjes
        final Parent root = loader.load();
        final Scene scene = new Scene(root, 250, 150);
        Stage stage = new Stage();
        // Stage sættes modal, så vinduet skal besvares
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initOwner(emailField.getScene().getWindow());
        stage.setScene(scene);
        stage.show();
    }

}