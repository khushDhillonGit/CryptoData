package com.example.cryptodata;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoinViewController implements Initializable {

    @FXML
    private ListView<Coin> dataList;

    @FXML
    private ChoiceBox<String> orderByCombo;

    @FXML
    private TextField searchField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderByCombo.getItems().addAll("price", "marketCap", "24hVolume", "change", "listedAt");
        orderByCombo.getSelectionModel().selectFirst();

    }

    @FXML
    void getCoins(ActionEvent event) throws IOException, InterruptedException {
        dataList.getItems().clear();
        String searchText = searchField.getText();
        APIResponse apiResponse = APIUtility.getCoinsFromAPI(searchText,orderByCombo.getValue());
        dataList.getItems().addAll(apiResponse.getData().getCoins());

    }

}
