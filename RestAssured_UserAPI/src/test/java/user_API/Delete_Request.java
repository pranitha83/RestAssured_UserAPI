package user_API;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import requestSpec.Requests;

public class Delete_Request {
Response response;
	@Test
	public void Delete_UserById() {
		response = RestAssured.given()
				   .spec(Requests.Delete_UserByUserId())
				   .pathParam("userId", Post_CreateUser.createdUserId)
				   .delete();
		response.then().log().all()
		.assertThat().statusCode(200);
	}
}
