package user_API;

import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import endPoints.URLs;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import utilities.ExcelReader;
public class Post_CreateUser {

	Response response;
	String Sheetname;
	int rownumber;
	public static String createdUserId;
	public static String  createdUserFirstname;


	//		 ExtentReports extent;
	//		    ExtentTest test;
	//
	//		    @BeforeTest
	//		    public void setUp() {
	//		        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-config.html");
	//		        extent = new ExtentReports();
	//		        extent.attachReporter(htmlReporter);
	//	}

	@Test
	public  void CreateUser() throws Throwable {
		
		List<Map<String, String>>map = ExcelReader.getData(URLs.Excelpath, "Sheet2");
		for (Map<String, String> row : map) {
			String firstname = row.get("user_first_name");
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
					.body(userInfoJson)
					.post(BaseUrl+endPoint);
			response.then().log().all();
			int statuscode = response.getStatusCode();
			createdUserId = response.jsonPath().getString("user_id");
			createdUserFirstname =response.jsonPath().getString("user_first_name");

			System.out.println(createdUserId);


			if(statuscode == 201) {	
				response.getStatusLine();
			}



			if (statuscode == 201) {
				// Assuming you have a response object named 'response'
				response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/TestData/Schema.json")));
				assertEquals(firstname,createdUserFirstname );
				assertEquals(lastname,response.jsonPath().getString("user_last_name") );
				assertEquals(phonenumber,response.jsonPath().getString("user_contact_number") );
				assertEquals(emailid,response.jsonPath().getString("user_email_id") );
				assertEquals(plotNumber,response.jsonPath().getString("userAddress.plotNumber") );
				assertEquals(street,response.jsonPath().getString("userAddress.street") );
				assertEquals(state,response.jsonPath().getString("userAddress.state") );
				assertEquals(country,response.jsonPath().getString("userAddress.country") );
				assertEquals(zipCode,response.jsonPath().getString("userAddress.zipCode") );



			}

			if (Integer.toString(statuscode) == ExpectedStatusCode) {
				response.then()
				.assertThat()
				.body("message", is(message)) // Use equalTo() matcher for comparison
				.body("status", is(status)); // Use equalTo() matcher for comparison
			}
			if(Integer.toString(statuscode) == ExpectedStatusCode) {
				response.then().assertThat()
				.body("error", is(errorMsg))
				.body("status", is(status));
			}
			 
		}


	}



}

