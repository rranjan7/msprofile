package com.googlesheet1.GoogleSheet1;

import java.util.Map;

public class Editions {
	
private String Edition_name;

 Map <String,String> price;
  private String offer_id;
  
  
public String getEdition_name() {
	return Edition_name;
}
public void setEdition_name(String edition_name) {
	Edition_name = edition_name;
}
public Map<String, String> getPrice() {
	return price;
}
public void setPrice(Map<String, String> price) {
	this.price = price;
}
public String getOffer_id() {
	return offer_id;
}
public void setOffer_id(String offer_id) {
	this.offer_id = offer_id;
}
}
