package utilities;

import java.util.List;
import java.util.Map;

public class ExcelDataProcessor {
	static String userInfoJson = null;
    public static String processExcelData(List<Map<String, String>> data) {
        for (Map<String, String> row : data) {
            String firstname = getValueOrDefault(row.get("user_first_name"));
            String lastname = getValueOrDefault(row.get("user_last_name"));
            String phonenumber = getValueOrDefault(row.get("user_contact_number"));
            String emailid = getValueOrDefault(row.get("user_email_id"));
            String plotNumber = getValueOrDefault(row.get("plotNumber"));
            String street = getValueOrDefault(row.get("Street"));
            String state = getValueOrDefault(row.get("state"));
            String country = getValueOrDefault(row.get("Country"));
            String zipCode = getValueOrDefault(row.get("zipCode"));
            String status = getValueOrDefault(row.get("status"));
            String message = getValueOrDefault(row.get("message"));

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
        }
		
		return userInfoJson;
    }

    private static String getValueOrDefault(String value) {
        return value != null ? value : "";
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    //List<String> jsonRequests = new ArrayList<>();
//
//    StringBuilder jsonRequests1 = new StringBuilder(); // Use StringBuilder to append JSON requests
//
//    for (Map<String, String> row : map) {
//        firstname = row.get("user_first_name");
//        lastname =  row.get("user_last_name");
//        phonenumber =  row.get("user_contact_number");
//        emailid = row.get("user_email_id");
//        plotNumber =  row.get("plotNumber");
//        street =  row.get("Street");
//        state = row.get("state");
//        country = row.get("Country");
//        zipCode = row.get("zipCode");
//
//        // Construct JSON for each row
//        String userInfoJson = "{" +
//                "\"user_first_name\": \"" + firstname + "\"," +
//                "\"user_last_name\": \"" + lastname + "\"," +
//                "\"user_contact_number\": \"" + phonenumber + "\"," +
//                "\"user_email_id\": \"" + emailid + "\"," +
//                "\"userAddress\": {" +
//                "\"plotNumber\": \"" + plotNumber + "\"," +
//                "\"street\": \"" + street + "\"," +
//                "\"state\": \"" + state + "\"," +
//                "\"country\": \"" + country + "\"," +
//                "\"zipCode\": " + zipCode +
//                "}" +
//                "}";
//
//        // Append JSON for current row to StringBuilder
//        jsonRequests1.append(userInfoJson).append(","); // Append a comma after each JSON request
//    }
//
//    // Remove the trailing comma
//    if (jsonRequests1.length() > 0) {
//        jsonRequests1.setLength(jsonRequests1.length() - 1); // Remove the last character (comma)
//    }
//
//    return jsonRequests1.toString(); // Return the concatenated JSON requests
//}
//}
//	public static  String JsonRequest() throws InvalidFormatException, IOException   {
//		//HashMap<String, String>map = new HashMap<String,String>();
//		List<Map<String, String>>map =  ExcelReader.getData(URLs.Excelpath, "Sheet1");
//
//
//
//
//
//			for(Map<String, String> data :map) {
//		firstname = data.get("user_first_name");
//		lastname =  data.get("user_last_name");
//		phonenumber =  data.get("user_contact_number");
//		emailid = data.get("user_email_id");
//		plotNumber =  data.get("plotNumber");
//		street =  data.get("Street");
//		state = data.get("state");
//		country = data.get("Country");
//		zipCode =data.get("zipCode");
//
//		//		
//		//		StringBuilder userAddressJson = new StringBuilder();
//		//		userAddressJson.append("\"userAddress\": {");
//		//
//		//
//		//
//		//		if (plotNumber != null) {
//		//			userAddressJson.append("\"plotNumber\": \"" + plotNumber + "\",");
//		//		}
//		//		if (street != null) {
//		//			userAddressJson.append("\"street\": \"" + street + "\",");
//		//		}
//		//		if (state != null) {
//		//			userAddressJson.append("\"state\": \"" + state + "\",");
//		//		}
//		//		if (country != null) {
//		//			userAddressJson.append("\"country\": \"" + country + "\",");
//		//		}
//		//		if (zipCode != null) {
//		//			userAddressJson.append("\"zipCode\": " + zipCode + ",");
//		//		}
//		//
//		//		// Remove the last comma if any properties were added
//		//		if (userAddressJson.charAt(userAddressJson.length() - 1) == ',') {
//		//			userAddressJson.deleteCharAt(userAddressJson.length() - 1);
//		//		}
//		//
//		//		userAddressJson.append("}");
//
//		UserInfoJson = "{" +
//				"\"user_first_name\": \"" + firstname + "\"," +
//				"\"user_last_name\": \"" + lastname + "\"," +
//				"\"user_contact_number\": \"" + phonenumber + "\"," +
//				"\"user_email_id\": \"" + emailid + "\"," +
//				"\"userAddress\": {" +
//
//	                "\"plotNumber\": \"" + plotNumber + "\"," +
//	                "\"street\": \"" + street + "\"," +
//	                "\"state\": \"" + state + "\"," +
//	                "\"country\": \"" + country + "\"," +
//	                "\"zipCode\": " + zipCode +
//	                "}" +
//	                "}";
//		
//
//
//
//
//
//
//
//
//	
//			
//		//return UserInfoJson;		
//			}
//			return UserInfoJson;
//}
//}
