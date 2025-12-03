package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelenPractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
         System.setProperty("webdriver.chrome.driver", "C:/Users/supub/OneDrive/Documents/chromedriver.exe/");
         WebDriver driver = new ChromeDriver();
         String password= forgotPassword(driver);
         driver.get("https://rahulshettyacademy.com/locatorspractice/");
         driver.findElement(By.id("inputUsername")).sendKeys("rahul");
         driver.findElement(By.name("inputPassword")).sendKeys(password);
         driver.findElement(By.className("signInBtn")).click();
         Thread.sleep(2000);
         //driver.close();
         
         		
	}
	
	public static String forgotPassword(WebDriver driver)  throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String passwordText= driver.findElement(By.cssSelector("form p")).getText();
		
		String [] passwordArray= passwordText.split("'");
		String password = passwordArray[1].split("'")[0];
		
		return password;
		
		
	}

}
