package PrTest;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import FilesAditya.Payload1;
import FilesAditya.Reusablemethods;

import static org.hamcrest.Matchers.*;

public class DynJason {
	
	@Test(dataProvider="BooksData")
	public void AddbookDeleteBook(String isbn, String aisle)
	{
		
		RestAssured.baseURI="http://216.10.245.166";

		 String Resp=given().log().all().header("Content-Type", "application/json")
		 .body(Payload1.addBook(isbn,aisle)) 
		 .when().post("Library/Addbook.php") 
		 .then().log().ifValidationFails().assertThat().statusCode(200).body("Msg",
		 equalTo("successfully added")).extract().response().asString(); 
		 
		 JsonPath jsn = Reusablemethods.rawToJson(Resp); 
		 String bookid=jsn.get("ID"); 
		 System.out.println(bookid);
	
		String Respdelete= given().log().all().header("Content-Type", "application/json")
				.body(Payload1.Deletebook(bookid))
				.when().delete("Library/DeleteBook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath jsn1=Reusablemethods.rawToJson(Respdelete);
		String delmsg=jsn1.get("msg");
		System.out.println(delmsg);
		
	}
	
@DataProvider(name="BooksData")
public Object[][] getdata()
{
	return new Object[][] {{"dhjf","0298"},{"kfou","03294"},{"owwkf","2004"}};
}
	
}
