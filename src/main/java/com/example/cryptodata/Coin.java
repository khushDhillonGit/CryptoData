package com.example.cryptodata;

import javafx.util.converter.CurrencyStringConverter;

import java.util.Locale;

public class Coin {
    private String symbol;
    private String name;
    private String iconUrl;
    private String marketCap;
    private String price;
    private int rank;
    private String change;

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getMarketCap() {
        if(marketCap != null){
            CurrencyStringConverter csv = new CurrencyStringConverter(Locale.CANADA);
            float marketCapF =  Float.valueOf(marketCap);
            return csv.toString(marketCapF);
        }else{
            return "[No Data Available]";
        }
    }

    public String getPrice() {
        if(price != null){
            CurrencyStringConverter csv = new CurrencyStringConverter(Locale.CANADA);
            float priceF =  Float.valueOf(price);
            return csv.toString(priceF);
        }else{
            return "[No Price Available]";
        }
    }

    public int getRank() {
        return rank;
    }

    public String getChange() {
        return change + "%";
    }

    public String toString(){
        return getName() + " (" + getSymbol() + ")" + " - " + getPrice();
    }

}
