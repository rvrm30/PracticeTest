package Selenium;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub\

		System.setProperty("webdriver.chrome.driver","C:/Users/supub/OneDrive/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//Q1.Give count of all the link on this page we can use tagname "a" as amy limk HTML starts with anchor 'a'
		System.out.println(driver.findElements(By.tagName("a")).size());

		//Q2.Give me count of link in the footer section
		WebElement footerDriver=driver.findElement(By.id("gf-BIG")); //Limiting WebDriver  scope of driver to footer section only
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		//Q.3 We want count of link counts for first section of footer section 

		WebElement coloumndriver=footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());

		//Q4. Click on each link in the coloumn and check if the pages are opening

		for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
		{
			//Step 1 : Opem all the req footer link
			String clickLinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);//control+enter simulation
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);
			Thread.sleep(5000);

		}//opens all the tabs
			//Now get the all title of opened link

			Set<String> abc=driver.getWindowHandles();	//4
			Iterator<String> it=abc.iterator();

			while(it.hasNext()) //if the next index is present or  it will execute till the condition is false
			{
				driver.switchTo().window(it.next()); //next her is moving to next index
				System.out.println(driver.getTitle());
			}
			
			
			//What is the optimization you did in you project the above is the answer 
		




	}

}
