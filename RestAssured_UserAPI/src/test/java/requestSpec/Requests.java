package requestSpec;


import endPoints.URLs;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Requests {
	private static void setAuth(RequestSpecBuilder req) {
		req.setAuth(RestAssured.basic(URLs.username, URLs.password));
	}

	static RequestSpecBuilder req = new RequestSpecBuilder();
	


	public static RequestSpecification Get_AllUsers() {
		RequestSpecBuilder req = new RequestSpecBuilder();
		req.setBaseUri(URLs.BaseUrl);
		req.setBasePath(URLs.Getallusers);
		setAuth(req);
		return req.build();
	}

	public static RequestSpecification Get_UserById() {
		RequestSpecBuilder req = new RequestSpecBuilder();
		req.setBaseUri(URLs.BaseUrl);
		req.setBasePath(URLs.GetUserById );
		setAuth(req);
		return req.build();
		}


	
	
	public static RequestSpecification Get_UserByFirstName() {
		RequestSpecBuilder req = new RequestSpecBuilder();
		req.setBaseUri(URLs.BaseUrl);
		req.setBasePath(URLs.GetUserByFirstName);
		setAuth(req);
		return req.build();
	}
	
//	public static  List<RequestSpecification> Create_User() throws Throwable, IOException {
//		
//		List<RequestSpecification> ReqSpec = new ArrayList<>();
//		List<Map<String, String>>map = ExcelReader.getData(URLs.Excelpath, "Sheet1");
//		for (Map<String, String> row : map) {
//			String firstname = row.get("user_first_name");
//			String lastname = row.get("user_last_name");
//			String phonenumber = row.get("user_contact_number");
//			String emailid = row.get("user_email_id");
//			String plotNumber = row.get("plotNumber");
//			String street = row.get("Street");
//			String state = row.get("state");
//			String country = row.get("Country");
//			String zipCode = row.get("zipCode");
//		//	String ExpectedStatusCode = row.get("ExpectedStatusCode");
//			String status = row.get("status");
//			String message = row.get("message");
//			String BaseUrl = row.get("Baseurl");
//			String endPoint = row.get("EndPoint");
//			//System.out.println(ExpectedStatusCode);
//			// Construct JSON for each row
//			String userInfoJson = "{" +
//					"\"user_first_name\": \"" + firstname + "\"," +
//					"\"user_last_name\": \"" + lastname + "\"," +
//					"\"user_contact_number\": \"" + phonenumber + "\"," +
//					"\"user_email_id\": \"" + emailid + "\"," +
//					"\"userAddress\": {" +
//					"\"plotNumber\": \"" + plotNumber + "\"," +
//					"\"street\": \"" + street + "\"," +
//					"\"state\": \"" + state + "\"," +
//					"\"country\": \"" + country + "\"," +
//					"\"zipCode\": " + zipCode +
//					"}" +
//					"}";
//		System.out.println(userInfoJson);
//		req = new RequestSpecBuilder();
//		req.setBaseUri(BaseUrl);
//		req.setBasePath(endPoint);
//		req.setAccept(ContentType.JSON);
//		setAuth(req);
//		req.setBody(userInfoJson);
//		ReqSpec.add(req.build());
//		
//		}
//		return ReqSpec;
//		}	
//		
	
	public static RequestSpecification Update_User() {
		req.setBaseUri(URLs.BaseUrl);
		req.setBasePath(URLs.UpdateUser);
		req.setAccept(ContentType.JSON);
		setAuth(req);
		return req.build();
	}

	
	public static RequestSpecification Delete_UserByFirstName() {
		req.setBaseUri(URLs.BaseUrl);
		req.setBasePath(URLs.DeleteUserByFirstName);
		setAuth(req);
		return req.build();
	}
	
	public static RequestSpecification Delete_UserByUserId() {
		req.setBaseUri(URLs.BaseUrl);
		req.setBasePath(URLs.DeleteUserByUserId);
		setAuth(req);
		return req.build();
	}
	
	}



