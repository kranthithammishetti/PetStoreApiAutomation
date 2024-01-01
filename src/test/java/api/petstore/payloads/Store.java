package api.petstore.payloads;

public class Store {

	/*
	 * Schema Elements {"id": 0, "petId": 0, "quantity": 0, "shipDate":
	 * "2023-12-31T12:54:25.480Z", "status": "placed", "complete": true}
	 */
	int id;
	int petId;
	int quantity;
	String shipDate;
	String status;
	Boolean complete;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

}
