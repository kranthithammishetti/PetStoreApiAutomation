package api.petstore.endpoints;

/**
 * Project: https://petstore.swagger.io/
 * Create(Post) --
 * https://petstore.swagger.io/v2/user 
 * Retrive(Get) --
 * https://petstore.swagger.io/v2/user/string 
 * Update(Put) ---
 * https://petstore.swagger.io/v2/user/string 
 * Delete(Delete) --
 * https://petstore.swagger.io/v2/user/abc
 **/

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";

	// User Module
	public static String post_url = base_url+"/user";
	//{username} --> this is a path parameter
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	
	
	// Pet Module

		//here you will create Pet modules URLs
	
	// Store Module
		//here you will create store modules URLs

}
