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
        return marketCap;
    }

    public String getPrice() {
        return price;
    }

    public int getRank() {
        return rank;
    }

    public String getChange() {
        return change;
    }

    public String toString(){
        if(getPrice() != null){
            CurrencyStringConverter csv = new CurrencyStringConverter(Locale.CANADA);
            float price =  Float.valueOf(getPrice());
            return getName() + " (" + getSymbol() + ")" + " - " + csv.toString(price);
        }else{
            return getName() + " (" + getSymbol() + ")" + "- [No Price Available]";
        }

    }

}
