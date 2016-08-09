package elbar;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/restful")
public class Service {
	DAO dao = new DAO();

	/*@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getusers() {
		return dao.getAllUsers();
	}
	
	@GET
	@Path("/allJ")
	//@Produces(MediaType.APPLICATION_JSON)
	public String getuser() {
		return dao.getAllUsers();
	}*/
	
	@GET
	@Path("/allX")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getusersX() {
		return dao.getAllUsers();
	}

}
