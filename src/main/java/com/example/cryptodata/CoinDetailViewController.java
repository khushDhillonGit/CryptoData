package com.example.cryptodata;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CoinDetailViewController {

    @FXML
    private Label changeLabel;

    @FXML
    private Label displayLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label marketCapLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label rankLabel;

    @FXML
    private Label symbolLabel;


    @FXML
    void changeSceneToDetails(ActionEvent event) throws IOException, InterruptedException {
        SceneChange.changeSceneToCoinView(event,"coin-view.fxml");
    }


    void putData(Coin coin){
        displayLabel.setText(coin.getName() + "(" + coin.getSymbol() + ")");
        nameLabel.setText(coin.getName());
        symbolLabel.setText(coin.getSymbol());
        marketCapLabel.setText(coin.getMarketCap());
        priceLabel.setText(coin.getPrice());
        rankLabel.setText(Integer.toString(coin.getRank()));
        changeLabel.setText(coin.getChange());

        String iconUrl = coin.getIconUrl();
        try{
            iconUrl = iconUrl.replace(".svg",".png");
            imageView.setImage(new Image(iconUrl));
        }catch (IllegalArgumentException e){
            imageView.setImage(new Image(Main.class.getResourceAsStream("images/default-coin.jpg")));
        }
    }

}
