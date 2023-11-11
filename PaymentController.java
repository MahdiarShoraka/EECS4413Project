package proj;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/payment")
public class PaymentController {

	private CardDAO cardDAO = new CardDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CreditCard> getAllCards() {
		return cardDAO.readAll();
	}
	
	@GET
	@Path("/order")
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard getCard(@QueryParam("cardNumber") long cardNumber) {
		return cardDAO.read(cardNumber);
	}
	
	@POST
	@Path("/submit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard createCard(CreditCard card) {
		return cardDAO.create(card);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CreditCard updateCard(@PathParam("id") long id, CreditCard card) {
		return cardDAO.update(id, card);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCard(@PathParam("id") long id) {
		cardDAO.delete(id);
	}

}
