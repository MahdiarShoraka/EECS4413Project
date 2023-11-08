package com.hsaini.studentapp;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/auctionitems")
public class AuctionItemController {
    private AuctionItemDAO auctionItemDAO = new AuctionItemDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuctionItem createAuctionItem(AuctionItem auctionItem) {
        // Use the AuctionItemDAO to save the item to the database.
        AuctionItem createdItem = auctionItemDAO.createAuctionItem(auctionItem);
        return createdItem;
    }

    @GET
    @Path("/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public AuctionItem getAuctionItem(@PathParam("itemId") int itemId) {
        // Use the AuctionItemDAO to retrieve an item by its ID.
        AuctionItem item = auctionItemDAO.getAuctionItemById(itemId);
        return item;
    }

    // Implement other CRUD methods (PUT, DELETE, GET all) as needed.
}
