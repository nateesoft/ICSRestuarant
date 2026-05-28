package com.ics.pos.restaurant.icsrestaurant.model;

import java.time.LocalDate;


public class SVoidBean {

    private LocalDate sDate;
    private String refNo;
    private String voiduser;
    private String voidtime;
    private String pindex;
    private String macno;
    private String cashier;
    private String time;
    private String vtable;
    private LocalDate date;
    private String pcode;
    private Float qty;
    private Float amt;
    private String voidmsg;
    private String rpause;

    public LocalDate getsDate() {
        return sDate;
    }

    public void setsDate(LocalDate sDate) {
        this.sDate = sDate;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getVoiduser() {
        return voiduser;
    }

    public void setVoiduser(String voiduser) {
        this.voiduser = voiduser;
    }

    public String getVoidtime() {
        return voidtime;
    }

    public void setVoidtime(String voidtime) {
        this.voidtime = voidtime;
    }

    public String getPindex() {
        return pindex;
    }

    public void setPindex(String pindex) {
        this.pindex = pindex;
    }

    public String getMacno() {
        return macno;
    }

    public void setMacno(String macno) {
        this.macno = macno;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVtable() {
        return vtable;
    }

    public void setVtable(String vtable) {
        this.vtable = vtable;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public Float getQty() {
        return qty;
    }

    public void setQty(Float qty) {
        this.qty = qty;
    }

    public Float getAmt() {
        return amt;
    }

    public void setAmt(Float amt) {
        this.amt = amt;
    }

    public String getVoidmsg() {
        return voidmsg;
    }

    public void setVoidmsg(String voidmsg) {
        this.voidmsg = voidmsg;
    }

    public String getRpause() {
        return rpause;
    }

    public void setRpause(String rpause) {
        this.rpause = rpause;
    }
    
    
}
