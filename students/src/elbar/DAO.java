package elbar;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DAO {
	public List<User> getAllUsers() {
		List<User> userList = null;
		String json = "";
		try {
			EntityManagerFactory emfactory = Persistence
					.createEntityManagerFactory("test");

			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();

			Query query = entitymanager.createQuery("SELECT u FROM User u");
			userList = (List<User>) query.getResultList();
			entitymanager.getTransaction().commit();
			//to convert list to json string
		   // json = new Gson().toJson(userList);
			
		}
		catch(Exception e){
			e.getMessage();
		}
		
		return userList;
		//return json;
	}
}
