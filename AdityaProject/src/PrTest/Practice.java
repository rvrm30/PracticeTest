package PrTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import FilesAditya.Payload1;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
				body(Payload1.AddPlace()).when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)")
				.extract().response().asString();
		JsonPath js = new JsonPath(response);
		String placeid=js.get("place_id");
		System.out.println(placeid);
		String newadd="NEW 76 Summer walk, USA";
		
		String updateaddressresponse= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+placeid+"\",\r\n"
						+ "\"address\":\""+newadd+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}\r\n"
						+ "")
				.when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"))
				.extract().response().asString();
		
		String getaddressresponse= given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeid)
				.when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js2= new JsonPath(getaddressresponse);
		String updatedadd=js2.get("address");
		
		Assert.assertEquals(newadd, updatedadd);
		
		String deleteaddresponse= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"place_id\":\""+placeid+"\"\r\n"
						+ "}\r\n"
						+ "").when().delete("maps/api/place/delete/json").then().log().all()
				.assertThat().statusCode(200).extract().response().asString();
		
		
		
	}

}
