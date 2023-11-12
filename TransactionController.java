package proj;

import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/payment")
public class TransactionController {

	private TransactionDAO tranDAO = new TransactionDAO();
	private ItemDAO itemDAO = new ItemDAO();
	// private UserDAO userDAO = new UserDAO();

	@POST
	@Path("/submit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction createCard(Transaction info, @QueryParam("itemID") int itemId, @QueryParam("userID") int userId,
			@QueryParam("isExpe") boolean isExpe) throws SQLException {

		Item item = itemDAO.read(itemId);

		double shippingPrice = item.getShippingPrice();
		double itemPrice = item.getPrice();
		double expePrice = 0;
		if (isExpe) {
			expePrice = item.getExpeditedCost();
		}
		double total = shippingPrice + itemPrice + expePrice;

		info.setTotalCost(total);

//		double rn = Math.random();
//		int trId = (int) Math.round(rn);
//		info.setTransactionID(trId);

		info.setItemID(itemId);
		info.setUserID(userId);

		return tranDAO.create(info);
	}

	@GET
	@Path("/order")
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction getCard(@QueryParam("id") int id, @QueryParam("item") int itemId,
			@QueryParam("user") int userId) {
		return tranDAO.read(id);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCard(@PathParam("id") int id) {
		tranDAO.delete(id);
	}

//	@PUT
//	@Path("/{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Transaction updateCard(@PathParam("id") long id, Transaction card) {
//		return cardDAO.update(id, card);
//	}

}
