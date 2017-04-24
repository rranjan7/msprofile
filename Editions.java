package com.appdirect.nitya.automation_project;

import java.util.Map;

public class Editions {
    
    private String editionName ;
    
    private Map<String,String> price;
    
    private String offerId ;
    public String getEditionName() {
        return editionName;
    }
    public void setEditionName(String editionName) {
        this.editionName = editionName;
    }
    public Map<String, String> getPrice() {
        return price;
    }
    public void setPrice(Map<String, String> price) {
        this.price = price;
    }
    public String getOfferId() {
        return offerId;
    }
    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}

