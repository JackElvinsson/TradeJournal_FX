package com.example.tradejournal_fx;

import java.time.LocalDate;

public class Trade {
    private String symbol;
    private double price;
    private int quantity;
    private LocalDate date;
    private double stopLoss;
    private double takeProfit;
    private String screenshotURL;

    public Trade(String symbol, double price, int quantity, LocalDate date, double stopLoss, double takeProfit, String screenshotURL) {
        this.symbol = symbol;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.stopLoss = stopLoss;
        this.takeProfit = takeProfit;
        this.screenshotURL = screenshotURL;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public double getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(double takeProfit) {
        this.takeProfit = takeProfit;
    }

    @Override
    public String toString() {
        return  symbol + '\'' +
                "," + price +
                "," + quantity +
                "," + date +
                "," + stopLoss +
                "," + takeProfit +
                "," + screenshotURL;
    }

    public String getScreenshotURL() {
        return screenshotURL;
    }

    public void setScreenshotURL(String screenshotURL) {
        this.screenshotURL = screenshotURL;
    }

}


