package user_API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import requestSpec.Requests;



public class GET_AllUsers {
	
	String createdUserId;
	Response response;
	
	
	
	@Test(description="Positive get all users")
	public void Get_allusers() {

  
		  response = RestAssured.given()
		    .spec(Requests.Get_AllUsers())
		    .get();
		  response.then().assertThat().statusCode(200);
			response.then().log().all();
}
 @Test(description = "Positive get user by id")
 public void Get_userbyId() {
	 
	 
		//String getuserId = ResponseData.getUserId();
		//System.out.println(getuserId);
	response = RestAssured.given()
			    .spec(Requests.Get_UserById())
			    .pathParam("userId", Post_CreateUser.createdUserId)
			    .get();
	 System.out.println(response.statusCode());
	 System.out.println(response.asPrettyString());
	 response.then().assertThat().statusCode(200);
	 response.then().log().all();
 }
	@Test(description = "Positive get user by Firstname")
	
	public void Get_userByFirstName() {
		response = RestAssured.given()
				.spec(Requests.Get_UserByFirstName())
				.pathParam("userFirstName", Post_CreateUser.createdUserFirstname)
				.get();
		response.then().assertThat().statusCode(200);
		response.then().log().all();
	}
 
 
}
