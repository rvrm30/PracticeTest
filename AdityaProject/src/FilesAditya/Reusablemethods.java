package FilesAditya;

import io.restassured.path.json.JsonPath;

public class Reusablemethods {
	
	public static JsonPath rawToJson(String response)
	{
		JsonPath jsn=new JsonPath(response);
		
		return jsn;
	}

}
