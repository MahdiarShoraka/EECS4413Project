package com.hsaini.studentapp;



import jakarta.servlet.http.HttpSession;

public class ForwardBid extends Bid {

	@Override
	public void setUp(HttpSession session, String id, String name, String highBid, String time, String price, String bidder) {
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("highBid", highBid);
		session.setAttribute("time", time);
		session.setAttribute("price", price);
		session.setAttribute("bidder", bidder);
	} //Why nothing is done with the session here?

}
