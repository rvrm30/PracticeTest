package FilesAditya;
import static io.restassured.RestAssured.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import Pojo.Location;
import Pojo.LoginRequest;
import Pojo.LoginResponse;
import Pojo.OrderDetails;
import Pojo.Orders;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class EcommerceWebsiteTest
{

	public static void main(String[] args)
	{
		RequestSpecification baseReq=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.build();
//Serialisation:converting java object to request body(lg)
		LoginRequest lg=new LoginRequest();
		lg.setUserEmail("aman.crossroad@gmail.com");
		lg.setUserPassword("Aman0912232007$");
		
//****ByPass SSL vertification using relaxedHTTPSValidation
//Deserialisation:converting response body to java object(lp)
		RequestSpecification req=given().relaxedHTTPSValidation().log().all().spec(baseReq).body(lg);

		LoginResponse lp =req.when().post("/api/ecom/auth/login")
				.then().extract().response().as(LoginResponse.class);

		System.out.println("Updated token"+ lp.getToken());
		String token=lp.getToken();
		System.out.println("Updated userid"+ lp.getUserId());
		String userId=lp.getUserId();
	



//*****Add Product
		RequestSpecification addProductBaseReq=new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();
		
		RequestSpecification  reqAddProduct=given().log().all().spec(addProductBaseReq)
				.param("productName", "Super CAR")
				.param("productAddedBy", userId)
				.param("productCategory", "fashion")
				.param("productSubCategory", "Poster")
				.param("productPrice", 11500)
				.param("productDescription", "Webseries")
				.param("productFor", "anygender")
				.multiPart("productImage", new File("C:\\Users\\supub\\Downloads\\Drone.jpg"));

		String addProductResponse=reqAddProduct.when()
				.post("/api/ecom/product/add-product").then().log().all().
				extract().response().asString();
		
		JsonPath js=new JsonPath(addProductResponse);
		String productId=js.get("productId");
		
		System.out.println("Product ID is :" + productId);
		
//*****CheckoutProduct	
	
		RequestSpecification createOrderBaseReq=new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.addHeader("Authorization", token)
		.setContentType(ContentType.JSON).build();
		
		
		OrderDetails orderDetail=new OrderDetails();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(productId);
		
		
		List<OrderDetails> orderDetailList=new ArrayList<OrderDetails>();
		orderDetailList.add(orderDetail);
						
		
		Orders order=new Orders();
		order.setOrders(orderDetailList);
		
		RequestSpecification createOrderReq=given().log().all().spec(createOrderBaseReq).body(order);
		
		String responseAddProduct=createOrderReq.when().post("/api/ecom/order/create-order").
				then().log().all().extract().response().asString();
		
		
		
//******Delete Product
		
		RequestSpecification deleteProdBaseReq=new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com/")
		.addHeader("Authorization" , token).setContentType(ContentType.JSON)
		.build();
		
		RequestSpecification deleteProdReq=given().log().all().spec(deleteProdBaseReq)
				.pathParam("productId",productId);	
		
		String deleteProdResponse=deleteProdReq.when().delete("api/ecom/product/delete-product/{productId}").
		then().log().all().extract().response().asString();		
		
		JsonPath js1=new JsonPath(deleteProdResponse);
		Assert.assertEquals("Product Deleted Successfully",js1.get("message"));
		
		

	}

}
