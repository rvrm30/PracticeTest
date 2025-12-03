package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/supub/OneDrive/Documents/chromedriver.exe/");
          WebDriver driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
          driver.manage().window().maximize();
          driver.get("https://www.amazon.com/");
          driver.findElement(By.xpath("//button[@type='submit']")).click();
          Actions a= new Actions(driver);
          WebElement move=driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));
          driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).click();
          a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
          a.moveToElement(move).build().perform();
          
	}

}
