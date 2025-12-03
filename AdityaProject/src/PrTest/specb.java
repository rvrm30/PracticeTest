package PrTest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import java.util.ArrayList;
import java.util.List;
import Pojo.AddPlace;
import Pojo.AddingPlace;
import Pojo.Loc;
import Pojo.Location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specb {

	public static void main(String[] args) {
		
		AddingPlace p= new AddingPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Frontline house");
		p.setPhonenumber("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		List<String> l= new ArrayList<String>();
		l.add("shoe park");
		l.add("shop");
	    p.setTypes(l);
	    
	    Loc loc= new Loc();
	    loc.setLat(-38.383494);
	    loc.setLong(33.427362);
	    p.setLoc(loc);
	    
		
        
	 RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addQueryParam("key","qaclick123").build();

	 RequestSpecification reqres= given().spec(req).body(p);
	 
	 ResponseSpecification res= new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	 
	 Response response=reqres.when().post("/maps/api/place/add/json").then().log().all().spec(res).extract().response();
	 
	 
	}

}
