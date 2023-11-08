package com.hsaini.studentapp;
import java.util.ArrayList;
import java.util.List;

public class AuctionItemDAO {
    private List<AuctionItem> auctionItems = new ArrayList<>();
    private int nextItemId = 1;

    public AuctionItem createAuctionItem(AuctionItem auctionItem) {
        auctionItem.setItemId(nextItemId);
        nextItemId++;
        auctionItems.add(auctionItem);
        return auctionItem;
    }

    public AuctionItem getAuctionItemById(int itemId) {
        for (AuctionItem item : auctionItems) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null; // Item not found
    }

    public List<AuctionItem> getAllAuctionItems() {
        return auctionItems;
    }

    public AuctionItem updateAuctionItem(int itemId, AuctionItem updatedItem) {
        for (int i = 0; i < auctionItems.size(); i++) {
            AuctionItem item = auctionItems.get(i);
            if (item.getItemId() == itemId) {
                auctionItems.set(i, updatedItem);
                return updatedItem;
            }
        }
        return null; // Item not found
    }

    public void deleteAuctionItem(int itemId) {
        auctionItems.removeIf(item -> item.getItemId() == itemId);
    }
}
