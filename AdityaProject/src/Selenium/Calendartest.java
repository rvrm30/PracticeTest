package Selenium;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendartest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/supub/OneDrive/Documents/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		String monthNumber="6";
		String date="15";
		String year="2027";
		String[] expectedList= {"6","15","2027"};
		//**To check css using browser console $('tag.classname')
		driver.findElement(By.cssSelector("input.react-date-picker__inputGroup__input")).click();
		driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector("button.react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='15']")).click();
        //**Date is coming 6/15/2027 so we can not do get text()
		List<WebElement> actualList=driver.findElements(By.cssSelector("input.react-date-picker__inputGroup__input"));

		for(int i=0;i<actualList.size();i++)
		{
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		driver.close();
	}

}
