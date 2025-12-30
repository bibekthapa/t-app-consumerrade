package com.example.model;

public class Price {

    private Double current;
    private Double open;
    private Double high;
    private Double low;
    private Double volumne;
    private Double close;

  

    public Price(Double current, Double open, Double high, Double low, Double volumne, Double close) {
        this.current = current;
        this.open = open;
        this.high = high;
        this.low = low;
        this.volumne = volumne;
        this.close = close;
    }
    public Double getPrice() {
        return current;
    }
    public void setPrice(Double current) {
        this.current = current;             
    }

      public Double getOpen() {
        return this.open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getHigh() {
        return this.high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return this.low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getVolumne() {
        return this.volumne;
    }

    public void setVolumne(Double volumne) {
        this.volumne = volumne;
    }

    public Double getClose() {
        return this.close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

}
