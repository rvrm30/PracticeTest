package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeWebdriver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/supub/OneDrive/Documents/chromedriver.exe/");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        System.out.println(driver.findElements(By.tagName("a")).size());
        
        WebElement footersection=driver.findElement(By.id("gf-BIG"));// limiting webdriver for footersection
        System.out.println(footersection.findElements(By.tagName("a")).size());
        
        WebElement columnsection= driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
        System.out.println(columnsection.findElements(By.tagName("a")).size());
        
        for(int i=1;i<columnsection.findElements(By.tagName("a")).size();i++) 
        {
        	String clicklinktab=Keys.chord(Keys.CONTROL,Keys.ENTER);
        	columnsection.findElements(By.tagName("a")).get(i).sendKeys(clicklinktab);
        	Thread.sleep(5000L);
        	
        }
        Set<String> abc= driver.getWindowHandles();
        Iterator<String>  it=abc.iterator();
        
        while(it.hasNext())
        {
        	driver.switchTo().window(it.next());
        	System.out.println(driver.getTitle());
        }
  
	}
}
