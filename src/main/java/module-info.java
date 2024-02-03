module com.example.chatpsp_pablo_fernando {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatpsp_pablo_fernando to javafx.fxml;
    exports com.example.chatpsp_pablo_fernando;
}