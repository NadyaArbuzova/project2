module com.example.project2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires args4j;


    opens com.example.project2 to javafx.fxml;
    exports com.example.project2;
}