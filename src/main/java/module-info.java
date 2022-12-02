module com.example.modaldialogmedfxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.modaldialogmedfxml to javafx.fxml;
    exports com.example.modaldialogmedfxml;
}