//ALERT POP UP HANDLING

package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String text = "Aditya";
		System.setProperty("webdriver.chrome.driver", "C:/Users/supub/OneDrive/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); // URL in browser
		driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		System.out.println((driver.switchTo().alert().getText()));
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();
		// here dismiss act as a cancel for alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

}
