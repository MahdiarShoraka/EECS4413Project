package proj;

public class CreditCard {

	private String cardHolderName;
	private long cardNumber;
	private String expDate;
	private int cvv;

	// Account Number
	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long accNumber) {
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
