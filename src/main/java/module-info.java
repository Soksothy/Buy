module com.example.buy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.buy to javafx.fxml;
    exports com.example.buy;
}