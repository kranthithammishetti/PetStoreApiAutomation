package api.petstore.endpoints;
import static io.restassured.RestAssured.*;

import api.petstore.payloads.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class PetEndPoints {

	//Create Pet
	public static Response createPet(Pet payload){
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.createPet_post_url);
		return response;
	}
	
	//Get Pet
	public static Response getPet(int petId){
		Response response =given()
		.accept(ContentType.JSON)
		.pathParam("id", petId)
		.when()
		.post(Routes.getPet_get_url);
		return response;
	}
	
	//Update Pet
	public static Response updatePet(int petId, Pet payload){
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("id", petId)
		.body(payload)
		.when()
		.post(Routes.updatePet_put_url);
		return response;
	}
	
	//Delete Pet
		public static Response deletePet(int petId){
			Response response =given()
			.accept(ContentType.JSON)
			.pathParam("id", petId)
			.when()
			.post(Routes.deletePet_delete_url);
			return response;
		}
}
