package com.ics.pos.restaurant.icsrestaurant.model;

import java.time.LocalDate;


public class SVatBean {

    private LocalDate tdate;
    private String terminal;
    private String macno;
    private String stbill;
    private String spbill;
    private Float netvat;
    private Float netnonvat;
    private Float vat;
    private Float netdiff;

    public LocalDate getTdate() {
        return tdate;
    }

    public void setTdate(LocalDate tdate) {
        this.tdate = tdate;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getMacno() {
        return macno;
    }

    public void setMacno(String macno) {
        this.macno = macno;
    }

    public String getStbill() {
        return stbill;
    }

    public void setStbill(String stbill) {
        this.stbill = stbill;
    }

    public String getSpbill() {
        return spbill;
    }

    public void setSpbill(String spbill) {
        this.spbill = spbill;
    }

    public Float getNetvat() {
        return netvat;
    }

    public void setNetvat(Float netvat) {
        this.netvat = netvat;
    }

    public Float getNetnonvat() {
        return netnonvat;
    }

    public void setNetnonvat(Float netnonvat) {
        this.netnonvat = netnonvat;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public Float getNetdiff() {
        return netdiff;
    }

    public void setNetdiff(Float netdiff) {
        this.netdiff = netdiff;
    }
    
    
}
