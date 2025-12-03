package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v112.input.Input;

public class Locators
{
	public static void main(String [] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/supub/OneDrive/Documents/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("adityaevol@gmail.com");
		driver.findElement(By.name("inputPassword")).sendKeys(("aditya123$"));
		driver.findElement(By.className("signInBtn")).click();
		System.out.print((driver.findElement(By.cssSelector("p.error")).getText()));
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Aditya Vimal");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("random@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("adityaevol@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7798292727");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println((driver.findElement(By.cssSelector("form p")).getText()));
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		
		//driver.close();
		}

}
