package com.hsaini.studentapp;

import jakarta.servlet.http.HttpSession;

public abstract class Bid {
	
	//does this method need to be final?
	public final void setType(HttpSession session, String id, String name, String highBid, String time, String price, String bidder){
		setUp(session, id, name, highBid, time, price, bidder); //why are we passing session if not needed?
		System.out.println("Bid Type excuted");
	}
	
	public abstract void setUp(HttpSession session, String id, String name, String highBid, String time, String price, String bidder);

}

//why do we need 2 methods for setType and setUp?
