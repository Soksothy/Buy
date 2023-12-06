module com.example.buy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buy to javafx.fxml;
    exports com.example.buy;
}