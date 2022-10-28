package com.example.projecttest;

public class Data {

    private String cardName;
    private long cardNumber;
    private int month;
    private int year;
    private int ccv;

    // constructor

    public Data(String cardName, long cardNumber, int month, int year, int ccv) {
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.ccv = ccv;
    }

    // getters and setters


    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
}
