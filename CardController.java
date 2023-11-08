package com.mshoraka.studentapp;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/payment")
public class CardController {

	private CardDAO cardDAO = new CardDAO();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard getCard(@PathParam("id") int id) {
		return cardDAO.read(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard createCard(CreditCard card) {
		return cardDAO.create(card);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard updateCard(@PathParam("id") int id, CreditCard card) {
		return cardDAO.update(id, card);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCard(@PathParam("id") int id) {
		cardDAO.delete(id);
	}

}
