package proj;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Path("/items")
public class ItemController {

	private ItemDAO itemDAO = new ItemDAO();
	
	
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getAllItems(){
		return itemDAO.readAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Item getItemById(@PathParam("id") int id) {
		return itemDAO.read(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("search/{keyword}")
	public List<Item> getItemsByKeyword(@PathParam("keyword") String keyword){
		return itemDAO.readByKeyword(keyword);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void createItem(Item item) {
		itemDAO.create(item);

	}
	
	
	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getSearchPage(@QueryParam("keyword") String keyword) {
	    
	    if (keyword == null || keyword.isEmpty()) {
	       return itemDAO.readAll();
	    }
	    else {
	    	return itemDAO.readByKeyword(keyword); 
	    }
	}


	
}
