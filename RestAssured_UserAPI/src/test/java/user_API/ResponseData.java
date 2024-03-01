package user_API;

public class ResponseData {

	private static String userId;

	public static String getUserId() {
		return userId;
	}

	public static String setUserId(String userId) {
		return ResponseData.userId = userId;
	}
	
}
