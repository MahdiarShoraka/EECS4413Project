package com.hsaini.studentapp;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/auction/dutch")
public class DutchAuctionController {

    private AuctionItemDAO auctionItemDAO = new AuctionItemDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuctionItem> getAllAuctionItems() {
        return auctionItemDAO.getAllAuctionItems();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuctionItem createAuctionItem(AuctionItem auctionItem) {
        return auctionItemDAO.createAuctionItem(auctionItem);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AuctionItem getAuctionItem(@PathParam("id") int id) {
        return auctionItemDAO.getAuctionItemById(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuctionItem updateAuctionItem(@PathParam("id") int id, AuctionItem auctionItem) {
        return auctionItemDAO.updateAuctionItem(id, auctionItem);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAuctionItem(@PathParam("id") int id) {
        auctionItemDAO.deleteAuctionItem(id);
    }
}
