package com.ics.pos.restaurant.icsrestaurant.model;

import java.time.LocalDate;


public class TOptionBean {

    private LocalDate sDate;
    private String macno;
    private String refno;
    private String rTable;
    private String rIndex;
    private String pcode;
    private Integer optindex;
    private String optname;

    public LocalDate getsDate() {
        return sDate;
    }

    public void setsDate(LocalDate sDate) {
        this.sDate = sDate;
    }

    public String getMacno() {
        return macno;
    }

    public void setMacno(String macno) {
        this.macno = macno;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public String getrTable() {
        return rTable;
    }

    public void setrTable(String rTable) {
        this.rTable = rTable;
    }

    public String getrIndex() {
        return rIndex;
    }

    public void setrIndex(String rIndex) {
        this.rIndex = rIndex;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public Integer getOptindex() {
        return optindex;
    }

    public void setOptindex(Integer optindex) {
        this.optindex = optindex;
    }

    public String getOptname() {
        return optname;
    }

    public void setOptname(String optname) {
        this.optname = optname;
    }
    
    
}
