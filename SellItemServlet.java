package com.hsaini.studentapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sell-item")
public class SellItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Extract item information from the request
        String description = request.getParameter("description");
        String auctionType = request.getParameter("auctionType");
        int duration = Integer.parseInt(request.getParameter("duration"));
        double startingBid = Double.parseDouble(request.getParameter("startingBid"));

        // Create an AuctionItem object with the extracted information
        AuctionItem auctionItem = new AuctionItem();
        auctionItem.setDescription(description);
        auctionItem.setAuctionType(auctionType);
        //auctionItem.setDuration(duration);
        //auctionItem.setStartingBid(startingBid);

        // Save the item to the database using the AuctionItemDAO
        AuctionItemDAO auctionItemDAO = new AuctionItemDAO();
        auctionItemDAO.createAuctionItem(auctionItem);

        // Optionally, redirect the user to a success page or show a confirmation message
        response.sendRedirect("success.jsp");
    }
}
