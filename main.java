package com.hsaini.studentapp;

import jakarta.servlet.http.HttpSession;

public class main {

    public static void main(String[] args) {
        // Create an instance of ForwardBid
        ForwardBid forwardBid = new ForwardBid();

        // You would typically obtain the HttpSession from your servlet context.
        // For the sake of this example, we'll create a mock HttpSession object.
        HttpSession session = new MockHttpSession(); // You need to implement MockHttpSession.

        // Sample data for setting up a bid
        String id = "1";
        String name = "Sample Item";
        String highBid = "100.00";
        String time = "12:00 PM";
        String price = "50.00";
        String bidder = "John Doe";

        // Call the setUp method to set up the bid in the session
        forwardBid.setUp(session, id, name, highBid, time, price, bidder);

        // You can now access the session to retrieve the bid data or perform other actions.
        // Note that the code here assumes you have implemented a MockHttpSession class.
    }
}
