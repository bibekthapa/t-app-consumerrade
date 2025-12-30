package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
public class TradeEntity {

   @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tradeId;
    private String tradeType;

    private double priceCurrent;
    private double priceOpen;
    private double priceHigh;
    private double priceLow;
    private double priceVolume;
    private double priceClose;

    private Long timestampEpochMillis; // nullable

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTradeId() {
    return this.tradeId;
  }

  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  public String getTradeType() {
    return this.tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public double getPriceCurrent() {
    return this.priceCurrent;
  }

  public void setPriceCurrent(double priceCurrent) {
    this.priceCurrent = priceCurrent;
  }

  public double getPriceOpen() {
    return this.priceOpen;
  }

  public void setPriceOpen(double priceOpen) {
    this.priceOpen = priceOpen;
  }

  public double getPriceHigh() {
    return this.priceHigh;
  }

  public void setPriceHigh(double priceHigh) {
    this.priceHigh = priceHigh;
  }

  public double getPriceLow() {
    return this.priceLow;
  }

  public void setPriceLow(double priceLow) {
    this.priceLow = priceLow;
  }

  public double getPriceVolume() {
    return this.priceVolume;
  }

  public void setPriceVolume(double priceVolume) {
    this.priceVolume = priceVolume;
  }

  public double getPriceClose() {
    return this.priceClose;
  }

  public void setPriceClose(double priceClose) {
    this.priceClose = priceClose;
  }

  public Long getTimestampEpochMillis() {
    return this.timestampEpochMillis;
  }

  public void setTimestampEpochMillis(Long timestampEpochMillis) {
    this.timestampEpochMillis = timestampEpochMillis;
  }

  //  @Lob
   // private byte[] avroData; // full Avro object
    
}