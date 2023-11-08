package proj;

public class Item {

	private int itemID;
    private String itemName;
    private String itemDescription;
    private double currentBiddingPrice;
    private String auctionType;
    private int remainingTime;
    private double expeditedShippingCost;
    private int sellerUserID;
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public double getCurrentBiddingPrice() {
		return currentBiddingPrice;
	}
	public void setCurrentBiddingPrice(double currentBiddingPrice) {
		this.currentBiddingPrice = currentBiddingPrice;
	}
	public String getAuctionType() {
		return auctionType;
	}
	public void setAuctionType(String auctionType) {
		this.auctionType = auctionType;
	}
	public int getRemainingTime() {
		return remainingTime;
	}
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	public double getExpeditedShippingCost() {
		return expeditedShippingCost;
	}
	public void setExpeditedShippingCost(double expeditedShippingCost) {
		this.expeditedShippingCost = expeditedShippingCost;
	}
	public int getSellerUserID() {
		return sellerUserID;
	}
	public void setSellerUserID(int sellerUserID) {
		this.sellerUserID = sellerUserID;
	}
    
    
    
}
