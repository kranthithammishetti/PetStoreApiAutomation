package api.petstore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import api.petstore.endpoints.StoreEndPoints;
import api.petstore.endpoints.UserEndPoints;
import api.petstore.payloads.Store;
import api.petstore.payloads.User;
import api.petstore.tests.StoreTests.STATUS;
import api.petstore.utilities.Common;
import api.petstore.utilities.DataProviders;
import io.restassured.response.Response;

public class UserModuleDataDrivenTests {
	/** User Module Data Driven Test **/
	// Create User
	@Test(priority = 1, dataProvider = "UserData", dataProviderClass = DataProviders.class)
	public void postUserDetails(String id, String username, String firstName, String lastName, String email,
			String password, String phone) {

		User userPayload = new User();
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);

		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// Delete User
	@Test(priority = 2, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void deleteUserByName(String username) {

		Response response = UserEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
