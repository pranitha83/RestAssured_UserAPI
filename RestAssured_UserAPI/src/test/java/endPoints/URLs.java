package endPoints;

public class URLs {
public static String username = "Numpy@gmail.com";
public static String password ="userAPI";
	public static String BaseUrl = "https://userapi-8877aadaae71.herokuapp.com/uap" ;
	public  static String Getallusers = "/users";
	public static String CreateUser = "/createusers";
	public static String Excelpath = "./src/test/resources/TestData/testdata.xlsx";
	public static String GetUserById = "/user/{userId}";
	public static String GetUserByFirstName = "/users/username/{userFirstName}";
	public static String UpdateUser = "/updateuser/{userId}";
	public static String DeleteUserByFirstName = "/deleteuser/username/{userfirstname}";
	public static String DeleteUserByUserId = "/deleteuser/{userId}\r\n";
	
	
	
	
	
	
	
	
	
	//Invalid url and endpoint
	
	public static String InvalidUrl ="https://userapi-8877aadaae71.herokuapp.com";
	public static String Invalid_endpoint = "/ab";
	
	
}
