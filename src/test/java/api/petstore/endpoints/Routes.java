package api.petstore.endpoints;

/**
 * Application Resource Endpoints of each Module Project:
 * https://petstore.swagger.io/ ***** USER ********** Create(Post):
 * https://petstore.swagger.io/v2/user Retrive(Get):
 * https://petstore.swagger.io/v2/user/string Update(Put):
 * https://petstore.swagger.io/v2/user/string Delete(Delete):
 * https://petstore.swagger.io/v2/user/abc ******* STORE ********* Create
 * Order(Post) https://petstore.swagger.io/v2/store/order Retrieve (GET):
 * https://petstore.swagger.io/v2/store/order/10 Delete(Delete) :
 * https://petstore.swagger.io/v2/store/order/101
 **/

public class Routes {
	// https://petstore.swagger.io/v2/pet
	public static String base_url = "https://petstore.swagger.io/v2";
	// https://petstore.swagger.io/v2/store/order

	// User Module
	public static String user_post_url = base_url + "/user";
	// {username} --> this is a path parameter
	public static String user_get_url = base_url + "/user/{username}";
	public static String user_update_url = base_url + "/user/{username}";
	public static String user_delete_url = base_url + "/user/{username}";

	// Store Module
	public static String store_post_url = base_url + "/store/order";
	public static String store_get_url = base_url + "/store/order/{storeId}";
	public static String store_delete_url = base_url + "/store/order/{storeId}";
	public static String store_update_url = base_url + "/store/order/{storeId}";

	// Pet Module
	public static String createPet_post_url = base_url + "/pet";
	public static String getPet_get_url = base_url + "/pet/{petId}";
	public static String updatePet_put_url = base_url + "/pet";
	public static String deletePet_delete_url = base_url + "/pet/{petId}";
	
	
}
