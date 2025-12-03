package PrTest;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pojo.Api;
import Pojo.GetCourse;
import Pojo.WebAutomation;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class oAuthTest {
	public static void main(String[] args) throws InterruptedException {
	
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\supub\\chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("rvrm30");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
//		
//		driver.findElement(By.cssSelector("input[type='password'")).sendKeys("Nayapassworddalo@1");
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//		Thread.sleep(5000);
//		String url=driver.getCurrentUrl();
		String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0Adeu5BWgjz4rMrvMv-PEylpyeg5wnoH_l42i2o7MycXJH72B_Knma35V9YoLkdF-cMA55w&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		
		String accessTokenresponse=given().urlEncodingEnabled(false)
 		.queryParam("code", code)
		.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParam("grant_type", "authorization_code")
		.when()
		.post("https://www.googleapis.com/oauth2/v4/token")
		.asString();
		
		JsonPath js= new JsonPath(accessTokenresponse);
		String accessToken=js.getString("access_token");
		
	GetCourse gc=given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
	.when().get("https://rahulshettyacademy.com/getCourse.php")
	.as(GetCourse.class);
	
	System.out.println(gc.getLinkedIn());
	System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	
	List<Api> apiCourse=gc.getCourses().getApi();
	 for(int i=0;i<apiCourse.size();i++)
	 {
		 if(apiCourse.get(i).getCourseTitle().equalsIgnoreCase("Selenium Webdriver Java"))
		 {
			 System.out.println(apiCourse.get(i).getPrice());
		 }
	 }
	//System.out.println(response);
	 String[] Coursetitles= {"Selenium Webdriver Java","Cypress","Protractor"};
	 
	 ArrayList<String> a= new ArrayList<String>();
	 
	 List<WebAutomation> w=gc.getCourses().getWebAutomation();
	 for(int j=0;j<w.size();j++)
	 {
		 a.add(w.get(j).getCourseTitle());
	 }
	 List<String> expectedlist=Arrays.asList(Coursetitles);
	 
	 Assert.assertTrue(a.equals(expectedlist));

   }
}
