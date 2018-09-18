package com.llm.a03cookie.a02.shoppingcart5;

public class Customer {
	
	private String name;
	private String address;
	private String cardType;
	private String card;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Customer(String name, String address, String cardType, String card) {
		super();
		this.name = name;
		this.address = address;
		this.cardType = cardType;
		this.card = card;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", cardType=" + cardType + ", card=" + card + "]";
	}
}
