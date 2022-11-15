module com.example.cryptodata {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cryptodata to javafx.fxml;
    exports com.example.cryptodata;
}