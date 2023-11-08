package com.hsaini.studentapp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ForwardAuctionServlet")
public class ForwardAuctionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ForwardAuctionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve user input for the new bidding price
        String newBiddingPriceString = request.getParameter("newBiddingPrice");
        float newBiddingPrice = Float.parseFloat(newBiddingPriceString);

        // Get the HttpSession object to manage the bid state
        HttpSession session = request.getSession();

        // Check if a bid has been placed
        if (request.getParameter("newBid") != null) {
            try {
                int newBid = Integer.parseInt(request.getParameter("newBid"));

                // Retrieve the current bid from the session (initially 0)
                int currentBid = (int) session.getAttribute("currentBid");

                // Check if the new bid is higher than the current bid
                if (newBid > currentBid) {
                    // Update the current bid in the session
                    session.setAttribute("currentBid", newBid);

                    out.println("<center>");
                    out.println("New bid has been updated. Current highest bid: $" + newBid);
                } else {
                    out.println("<center>");
                    out.println("Error: Bid must be higher than the current highest bid.");
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Forward Auction Page</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Forward Auction</h1>");
            out.println("<p>Current highest bid: $" + session.getAttribute("currentBid") + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
