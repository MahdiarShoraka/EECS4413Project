package com.hsaini.studentapp;

import jakarta.servlet.http.HttpSession;

public class DutchBid extends Bid{

	@Override
	public void setUp(HttpSession session, String id, String name, String highBid, String time, String price,
			String bidder) {
		
		session.setAttribute("id", id);
	    session.setAttribute("name", name);
	    session.setAttribute("price",highBid);

	}

}
