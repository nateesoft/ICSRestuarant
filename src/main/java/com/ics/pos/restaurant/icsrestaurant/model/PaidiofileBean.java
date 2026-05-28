package com.ics.pos.restaurant.icsrestaurant.model;

import java.time.LocalDate;


public class PaidiofileBean {

    private LocalDate date;
    private String time;
    private String cashier;
    private String terminal;
    private String flage;
    private Float paidinamt;
    private Float paidoutamt;
    private String reson;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getFlage() {
        return flage;
    }

    public void setFlage(String flage) {
        this.flage = flage;
    }

    public Float getPaidinamt() {
        return paidinamt;
    }

    public void setPaidinamt(Float paidinamt) {
        this.paidinamt = paidinamt;
    }

    public Float getPaidoutamt() {
        return paidoutamt;
    }

    public void setPaidoutamt(Float paidoutamt) {
        this.paidoutamt = paidoutamt;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }
    
    
}
