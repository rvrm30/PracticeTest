package Selenium;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/supub/OneDrive/Documents/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//**Implicit wait declaration
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);//this is decrecate in recent selenium version starting from 4
		//**Explicit Wait
		//WebDriverWait w=new WebDriverWait(driver,5); // decrecate in selemihm recent version use below code
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsNeeded= {"Brocolli","Beetroot","Brinjal","Carrot"};
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	

	}
	//Need to create driver as an argument to give life to driver inside declared in method
	public static void addItems(WebDriver driver,String [] itemsNeeded)
	{
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));

		for(int i=0;i<products.size();i++)
		{
			String [] name=products.get(i).getText().split("-"); //Splitting the Cucumber - 1 kg we only want cucumber her
			String formattedName=name[0].trim(); //format to get acutal vegetable name i.e Cucumber
			//converting array into arralist
			List itemNeededList=Arrays.asList(itemsNeeded);
			if(itemNeededList.contains(formattedName))
			{
				j++;
				//click to add card button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				{
					if(j==itemsNeeded.length)
						break;
				}
			}
		}
	}
}


