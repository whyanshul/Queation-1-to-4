package TestNg;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGQuestions {
	
	public static WebDriver driver;
	@BeforeMethod
	void Quesion1() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		System.out.println("Now Browser has been opened");
	}
	
	@Test(dataProviderClass  = Question3.class,dataProvider = "getData")
	void loginFailed(String username, String password, String test) {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='Submit']")).click();		
		WebElement emptyText = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		assertEquals(emptyText.getText(), test , "The expected value and Actual value is not matching");
	
	}
	
	@AfterMethod
	void tearDown() {
		driver.close();
	}
	
}
