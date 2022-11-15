package com.example.cryptodata;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CoinViewController {

    @FXML
    private ListView<?> dataList;

    @FXML
    private ChoiceBox<?> orderByCombo;

    @FXML
    private TextField searchField;

}
