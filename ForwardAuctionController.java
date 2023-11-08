/*
package com.hsaini.studentapp;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/auctions")
public class ForwardAuctionController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response bid(
        @Context ServletContext servletContext,
        @Context HttpServletRequest request,
        @QueryParam("checked") String checked,
        @QueryParam("userName") String userName
    ) {
        String name = "";
        String desc = "";
        String ship = "";
        String price = "";
        String highBid = "";
        String aucType = "";
        String time = "";
        String bidder = "";
        String id = "";

        // Get the HttpSession object to manage the bid state
        HttpSession session = request.getSession();

        // Your database connection setup code here
        // Make sure to initialize the JDBC connection and retrieve the necessary data from the database

        if (aucType != null) {
            String target = "";
            if (aucType.equals("Forward")) {
                target = "/ForwardPage.jsp";
                Bid bidType = new ForwardBid();
                bidType.setType(session, id, name, highBid, time, price, bidder);
            } else if (aucType.equals("Dutch")) {
                target = "/DutchPage.jsp";
                Bid bidType = new DutchBid();
                bidType.setType(session, id, name, highBid, time, price, bidder);
            } else {
                return Response.status(Status.NOT_FOUND).build();
            }
            return Response.ok(target, MediaType.TEXT_HTML).build();
        } else {
            session.setAttribute("error", "You didn't select an item. Please go back to the last page.");
            String errorPage = "/ErrorPage.jsp";
            return Response.ok(errorPage, MediaType.TEXT_HTML).build();
        }
    }
}*/
