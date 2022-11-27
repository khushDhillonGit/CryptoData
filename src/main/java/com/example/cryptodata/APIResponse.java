package com.example.cryptodata;

public class APIResponse {
    private String status;
    private Data data;

    public boolean getStatus() {
        return status.equalsIgnoreCase("success");
    }
    public boolean validData(){
        return data.getCoins().length > 0;
    }
    public Data getData() {
        return data;
    }
}
