package elbar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.json.JSONObject;

@Path("/restful")
public class Service {
	DAO dao = new DAO();
	
	@Context
	ServletContext servContext;

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
	
	
	@GET
	@Path("/main")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMusicArchiveGenres() {
		File musicJsonFile = null;
		FileReader fileReader = null;
		String jsonString = null;
		JSONObject initialJsonObject = null;
		ResponseBuilder responseBuilder = null;

		try {
			URL tempURL = servContext.getResource("/data/music.json");
			System.out.println(tempURL.getPath());
			if (tempURL != null) {
				musicJsonFile = new File(tempURL.getFile());
				fileReader = new FileReader(musicJsonFile);
				int fileLength = (int)musicJsonFile.length();
				char[] contentCharArray = new char[fileLength];
				fileReader.read(contentCharArray);
				jsonString = new String(contentCharArray);
			}

		} catch (MalformedURLException exception) {
			exception.printStackTrace();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		if (musicJsonFile.exists() && fileReader != null && !jsonString.isEmpty()) {
			initialJsonObject = new JSONObject(jsonString);
			System.out.println(initialJsonObject);
				
		}
		
		responseBuilder = Response.ok(initialJsonObject.toString());
		return responseBuilder.build();

	}

}
