package com.mshoraka.studentapp;

public class CreditCard {

	private String cardHolderName;
	private int cardNumber;
	private String expDate;
	private int cvv;

	// Account Number
	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int accNumber) {
		this.cardNumber = accNumber;
	}

	// Account Name
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String accName) {
		this.cardHolderName = accName;
	}

	// Expiration Date
	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	// Security Code
	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}
