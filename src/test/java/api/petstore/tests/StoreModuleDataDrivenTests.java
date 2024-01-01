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

public class StoreModuleDataDrivenTests {
	/** Store Module Data Driven Test **/
	// Create Store
	@Test(priority = 1, dataProvider = "StoreData", dataProviderClass = DataProviders.class)
	public void postStoreDetails(String id, String petId, String quantity, String shipDate, String status,
			String complete) {
		Store storePayload = new Store();
		shipDate = Common.currentDateTimeWithHMS();
		storePayload.setId(Integer.parseInt(id));
		storePayload.setPetId(Integer.parseInt(petId));
		storePayload.setQuantity(Integer.parseInt(quantity));
		storePayload.setShipDate(shipDate);
		storePayload.setStatus(STATUS.PLACED.toString());
		storePayload.setComplete(Boolean.parseBoolean(complete));

		Response response = StoreEndPoints.createStore(storePayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	// DeleteStore
	@Test(priority = 2, dataProvider = "StoreIdData", dataProviderClass = DataProviders.class)
	public void deleteStoreById(String storeId) {

		Response response = StoreEndPoints.deleteStore(Integer.parseInt(storeId));
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
