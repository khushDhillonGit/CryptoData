module com.example.cryptodata {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.cryptodata to javafx.fxml, com.google.gson;
    exports com.example.cryptodata;
}