package com.example.model;
import java.sql.Time;

public class Trade {


    private String tradeId;
    private String tradeType;
    private Price price;
    private Time timestamp;


    public Trade() {
    }

    public Trade(String tradeId, String tradeType, Price  Price) {
        this.tradeId = tradeId;
        this.tradeType = tradeType;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
        this.price = price;
    }
    public Time getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Time timestamp) {
        this.timestamp = timestamp;
    }

}
