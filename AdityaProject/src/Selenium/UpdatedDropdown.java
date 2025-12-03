package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:/Users/supub/OneDrive/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //URL in browser

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Chek if checkbox is checked
		//driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//Check if checbox is slected or not?
		//driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Checked if date calender is enable or disabled
		
		
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5"))
		{
			System.out.println("It's enabled");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("ITs disabled");
			Assert.assertTrue(false);
		}

		
		
		
		
		//Get all checkboxes count on the page
		int TotalChecboxes=driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println(TotalChecboxes);

		driver.findElement(By.cssSelector("div.paxinfo")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("hrefIncAdt")).click();//2 Adults	
		//int i=1;
		//		while(i<5)
		//		{
		//			driver.findElement(By.id("hrefIncAdt")).click();
		//			i++;
		//		}

		for(int i=0;i<4;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.paxinfo")).getText(), "5 Adult");
	}

}
