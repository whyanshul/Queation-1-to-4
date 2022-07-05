package TestNg;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Question3 {
	
	
	@DataProvider
	public Object[][] getData(){
		System.out.println();
		Object[][] data = new Object[3][3];
		
		
		
		
		data[0][0] ="";
		data[0][1] ="admin";
		data[0][2] ="Username cannot be empty";
		
		
		
		
		data[0][0] ="admin";
		data[0][1] ="admin";
		data[0][2] ="Invalid credentials";
		
		
		
		
		data[0][0] ="admin";
		data[0][1] ="";
		data[0][2] ="Password cannot be empty";
		
		
		
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void loginfailed(String username, String password, String test) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		System.out.println("Browser has been opened");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='Submit']")).click();		
		WebElement emptyText = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		assertEquals(emptyText.getText(), test , "The expected value and Actual value is not matching");
		driver.close();
	}
}
