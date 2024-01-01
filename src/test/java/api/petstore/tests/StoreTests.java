package api.petstore.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.petstore.endpoints.StoreEndPoints;
import api.petstore.payloads.Store;
import api.petstore.utilities.Common;
import io.restassured.response.Response;

public class StoreTests {
	Faker faker;
	Store storePayload;
	public Logger logger;
	

	@BeforeClass
	public void setpData() {
		faker = new Faker();
		storePayload = new Store();
		logger = LogManager.getLogger(this.getClass());
		
		logger.info("Started Executing Stre Tests");
		logger.info("Creating Test Data for Store Creation");
		// Setup Store Test Data
		// storePayload.setPetId(random.nextInt(5, 10));
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(Common.randomNumberBetween(1, 5));
		storePayload.setShipDate(Common.currentDateTimeWithHMS());
		storePayload.setStatus(STATUS.PLACED.toString());
		storePayload.setComplete(faker.bool().bool());

	}

//Create Store
	@Test(priority = 1)
	public void createStore() {
		Response resonse = StoreEndPoints.createStore(storePayload);
		resonse.then().log().all();
		Assert.assertEquals(resonse.getStatusCode(), 200);
		logger.info("Create Store Response is: <!-- " + resonse.body().asString() + " --> End Of Response");
	}

// Get Store
	@Test(priority = 2)
	public void getStoreById() {
		Response resonse = StoreEndPoints.getStore(this.storePayload.getId());
		resonse.then().log().all();
		Assert.assertEquals(resonse.getStatusCode(), 200);
		logger.info("GET Store Response is: <!-- " + resonse.body().asString() + " --> End Of Response");
	}

//Update Store Method is not yet implemented, will run this test once put method is available for the resource
	@Test(priority = 3)
	@Ignore
	public void updateStoreById() {
		logger.info("******************* Updating Quantity, Shipment Date ***********");
		storePayload.setQuantity(Common.randomNumberBetween(1, 5));
		storePayload.setShipDate(Common.currentDateTimeWithHMS());
		Response resonse = StoreEndPoints.updateStore(this.storePayload.getId(), storePayload);
		resonse.then().log().all();
		Assert.assertEquals(resonse.getStatusCode(), 200);
		logger.info("Updated Store Response is: <!-- " + resonse.body().asString() + " --> End Of Response");

	}

//Delete Store
	@Test(priority = 4)
	public void deleteStoreById() {
		Response resonse = StoreEndPoints.deleteStore(this.storePayload.getId());
		resonse.then().log().all();
		Assert.assertEquals(resonse.getStatusCode(), 200);
		logger.info("DELETE Store Response is: <!-- " + resonse.body().asString() + " --> End Of Response");
	}

	public static enum STATUS {
		BOOKED, PLACED, ADDED_IN_CART, SHIPPED, IN_TRANSIT, DELIVERED, RETURNED, RTO_DELIVERED

	}
}
