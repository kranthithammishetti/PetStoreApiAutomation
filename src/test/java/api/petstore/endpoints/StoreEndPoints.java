package api.petstore.endpoints;

import static io.restassured.RestAssured.*;
import api.petstore.payloads.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * This class is created to perform the CRUD operations on the Store API.
 **/
public class StoreEndPoints {
//Create Store
	public static Response createStore(Store payload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when().post(Routes.store_post_url);;
		return response;
		
	}
//Get Store	
	public static Response getStore(int storeId)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("storeId", storeId)
		.when()
		.get(Routes.store_get_url);
		return response;
		
	}
//Update Store
	public static Response updateStore(int storeId, Store payload)
	{
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("id", storeId)
		.body(payload)
		.when()
		.put(Routes.store_update_url);
		return response;
	}
	
//Delete Store
	public static Response deleteStore(int storeId)
	{
	Response response = given()
		.pathParam("storeId", storeId)
		.when()
		.delete(Routes.store_delete_url);
	return response;
		
	}
	
}
