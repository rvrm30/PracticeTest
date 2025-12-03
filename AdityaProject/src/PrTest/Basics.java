package PrTest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import FilesAditya.Payload1;
import FilesAditya.Reusablemethods;

public class Basics {

	public static void main(String[] args) throws IOException {

		 RestAssured.baseURI="https://rahulshettyacademy.com";
//		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
//		.body(Payload1.AddPlace()).when().post("maps/api/place/add/json")
//		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
//		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

//		RequestSpecification req = new RequestSpecBuilder().setContentType(ContentType.JSON)
//				.setBaseUri("https://rahulshettyacademy.com")
//				.addQueryParam("key", "qaclick123")
//				.build();
//		ResponseSpecification res= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
//				.build();		
//		RequestSpecification resp=given().spec(req)
//		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\supub\\addplace.json"))));
//
//String response = resp.when().post("maps/api/place/add/json")
//.then().spec(res).extract().response().toString();

//System.out.println(response);

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\supub\\addplace.json")))).when()
				.post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

		JsonPath js = new JsonPath(response);
		String placeid = js.getString("place_id");
		String newAddress = "75 NEW ADDRESS Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		String getPlaceresponsevalue = given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id", placeid).when().get("maps/api/place/get/json").then().assertThat()
				.statusCode(200).extract().response().asString();

		System.out.println(getPlaceresponsevalue);

		JsonPath js2 = new JsonPath(getPlaceresponsevalue);
		String actualAddress = js2.getString("address");
		System.out.println(actualAddress);

//		JsonPath jsp=new JsonPath(getPlaceresponsevalue);
//		String actualAddress=jsp.getString("address");	
//		System.out.println(actualAddress);	

		Assert.assertEquals(newAddress, actualAddress);
	}

}
