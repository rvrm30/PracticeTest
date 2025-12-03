package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggest {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/supub/OneDrive/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Aus");
		Thread.sleep(2000);
		//*8Find the generic locator to iterae over list  uisnf parent child relation used below :
		List<WebElement> options=driver.findElements(By.cssSelector("ul[id='ui-id-1'] a"));

		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase("Austria"))
			{
				option.click();
				break;
			}
		}

	}

}
