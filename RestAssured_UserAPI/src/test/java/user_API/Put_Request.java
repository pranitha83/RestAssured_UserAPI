package user_API;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import endPoints.URLs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import requestSpec.Requests;
import utilities.ExcelReader;

public class Put_Request {
  Response response;
  @Test
	public void Update_user() throws Throwable, IOException {
		
		List<Map<String, String>>map = ExcelReader.getData(URLs.Excelpath, "UpdateUser");
		for (Map<String, String> row : map) {
			String firstname = row.get("updatedname");
			String lastname = row.get("user_last_name");
			String phonenumber = row.get("user_contact_number");
			String emailid = row.get("user_email_id");
			String plotNumber = row.get("plotNumber");
			String street = row.get("Street");
			String state = row.get("state");
			String country = row.get("Country");
			String zipCode = row.get("zipCode");
			String BaseUrl = row.get("Baseurl");
			String endPoint = row.get("EndPoint");
			String ExpectedStatusCode =( row.get("ExpectedStatusCode"));
			String status = row.get("status");
			String message = row.get("message");
			String errorMsg = row.get("error");
			//System.out.println(ExpectedStatusCode);
			// Construct JSON for each row
			String userInfoJson = "{" +
					"\"user_first_name\": \"" + firstname + "\"," +
					"\"user_last_name\": \"" + lastname + "\"," +
					"\"user_contact_number\": \"" + phonenumber + "\"," +
					"\"user_email_id\": \"" + emailid + "\"," +
					"\"userAddress\": {" +
					"\"plotNumber\": \"" + plotNumber + "\"," +
					"\"street\": \"" + street + "\"," +
					"\"state\": \"" + state + "\"," +
					"\"country\": \"" + country + "\"," +
					"\"zipCode\": " + zipCode +
					"}" +
					"}";

			System.out.println(userInfoJson);



			response = RestAssured.given()
					.auth().preemptive().basic(URLs.username, URLs.password)
					.header("Content-Type","Application/Json")
					.spec(Requests.Update_User())
					.pathParam("userId",Post_CreateUser.createdUserId)
					.body(userInfoJson)
					
					.put();
			response.then().log().all();
			int statuscode = response.getStatusCode();
		System.out.println(statuscode);
	}
	}
}
