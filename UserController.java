package proj;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
public class UserController {

    private UserDAO userDAO = new UserDAO();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        return userDAO.readAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getUserById(@PathParam("id") int id) {
        return userDAO.read(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(User user) {
        userDAO.create(user);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") int id) {
        userDAO.delete(id);
    }
    
    @POST
    @Path("/auth")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean authenticateUser(UserCredentials credentials) {
        String userName = credentials.getUserName();
        String password = credentials.getPassword();

        // Perform authentication logic
        User authenticatedUser = userDAO.authenticate(userName, password);

        return authenticatedUser != null;
    }
   
  
}
