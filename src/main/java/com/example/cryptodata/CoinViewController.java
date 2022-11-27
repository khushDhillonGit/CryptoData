package com.example.cryptodata;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


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

    @FXML
    private ImageView imageView;

    @FXML
    private Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderByCombo.getItems().addAll("price", "marketCap", "24hVolume", "change", "listedAt");
        orderByCombo.getSelectionModel().selectFirst();
        imageView.setImage(new Image(Main.class.getResourceAsStream("images/default-coin.jpg")));
        errorLabel.setText("Crypto is Love!");
        errorLabel.setTextFill(Color.color(1,0,0));

        dataList.getSelectionModel().selectedItemProperty().addListener((obs,old,coinSelected)->{

            if(coinSelected != null){
                String iconUrl = coinSelected.getIconUrl();
                try{
                    iconUrl = iconUrl.replace(".svg",".png");
                    imageView.setImage(new Image(iconUrl));
                }catch (IllegalArgumentException e){
                    imageView.setImage(new Image(Main.class.getResourceAsStream("images/default-coin.jpg")));
                }
            }
        });
    }

    @FXML
    void getCoins(ActionEvent event) throws IOException, InterruptedException {
        dataList.getItems().clear();
        String searchText = searchField.getText();
        if(!searchText.isBlank()) {
            errorLabel.setText("Crypto is Love!");
            APIResponse apiResponse = APIUtility.getCoinsFromAPI(searchText, orderByCombo.getValue());
            dataList.getItems().addAll(apiResponse.getData().getCoins());

        }else{
            errorLabel.setText("Please enter a search value");
        }
    }


}
