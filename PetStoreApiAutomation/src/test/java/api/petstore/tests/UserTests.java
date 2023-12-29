package api.petstore.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.petstore.endpoints.UserEndPoints;
import api.petstore.payloads.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayload;
public Logger logger;
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	
		//logs
		logger=LogManager.getLogger(this.getClass());
	}

	// Create User
	@Test(priority = 1)
	public void postUserDetails() {
		logger.info("******************* Creating User through post method ***********");
		Response resonse = UserEndPoints.createUser(userPayload);
		resonse.then().log().all();
		Assert.assertEquals(resonse.getStatusCode(), 200);
		// Assert.assertEquals(resonse.getBody().asString()., null);
		logger.info("******************* User is Created through post method ***********");
	}

	// Get User
	@Test(priority = 2)
	public void getUserByName() {
		logger.info("******************* Reading User Info through Get method ***********");
		Response resonse = UserEndPoints.readUser(this.userPayload.getUsername());
		resonse.then().log().all();
		Assert.assertEquals(resonse.getStatusCode(), 200);
		logger.info("******************* User details retrived ***********");
	}

	// Update User
	@Test(priority = 3)
	public void updateUserByName() {
		// Updating FirstName, LastName and Email
		logger.info("******************* Updating FirstName, LastName and Email through put method ***********");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response resonse = UserEndPoints.uppdateUser(this.userPayload.getUsername(), userPayload);
		resonse.then().log().all();
		resonse.then().log().body().statusCode(200);
		// OR
		Assert.assertEquals(resonse.getStatusCode(), 200);

		// Check data after updating
		Response resonseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
		resonseAfterUpdate.then().log().all();
		Assert.assertEquals(resonse.getStatusCode(), 200);
		logger.info("******************* Updated FirstName, LastName and Email through put method ***********");

	}

	// Delete User
	@Test(priority = 4)
	public void deleteUserByName() {
		logger.info("******************* Deleting user through delete method using userName ***********");
		Response resonseAfterDelete = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(resonseAfterDelete.getStatusCode(), 200);
		logger.info("******************* User deleted successfully ***********");

	}
}
