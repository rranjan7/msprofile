package com.SpreadSheet;


import java.util.List;
import java.util.Map;
public class Editions {
    
    private String editionName ;
    
    private String uSDprice;
    private String aUDprice;
    private String gBPprice;
    private String eURprice;
    
    private String offerId ;
    public String getEditionName() {
        return editionName;
    }
    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }
    
    public String getuSDprice() {
        return uSDprice;
    }
    public void setuSDprice(String uSDprice) {
        this.uSDprice = uSDprice;
    }
    public String getaUDprice() {
        return aUDprice;
    }
    public void setaUDprice(String aUDprice) {
        this.aUDprice = aUDprice;
    }
    public String getgBPprice() {
        return gBPprice;
    }
    public void setgBPprice(String gBPprice) {
        this.gBPprice = gBPprice;
    }
    public String geteURprice() {
        return eURprice;
    }
    public void seteURprice(String eURprice) {
        this.eURprice = eURprice;
    }
    public String getOfferId() {
        return offerId;
    }
    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}
