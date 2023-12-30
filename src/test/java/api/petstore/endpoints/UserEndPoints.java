package api.petstore.endpoints;

import static io.restassured.RestAssured.given;

import api.petstore.payloads.User;
import io.restassured.http.*;
import io.restassured.response.Response;

/**
 * This will created to perform the CRUD operations on the API.
 **/
public class UserEndPoints {
//Create User
	public static Response createUser(User payload) 
	{
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			.when()
			.post(Routes.post_url);
		return response;
	}
// Read / retrive / get user
	public static Response readUser(String username) 
	{
		Response response= given()
				.pathParam("username", username)
				.when()
				.get(Routes.get_url);
		return response;
	}	
	
// Update User
	public static Response uppdateUser(String username, User payload) 
	{
		Response response= given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
			.when()
			.put(Routes.update_url);
		return response;
	}
//Delete user
	public static Response deleteUser(String username) 
	{
		Response response= given()
				.pathParam("username", username)
				.when()
				.delete(Routes.delete_url);
		return response;
	}	
	
}
