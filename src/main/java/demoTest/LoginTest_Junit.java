package demoTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {
	
	WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("This is before class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("This is after class");
	}
	
	
	@Before
	public void launchBrowser() {	
		System.out.println("This is Before");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\19723\\june2021_Selenium-Eclipse\\crm2\\driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", ".\\driver\\\\chromedriver.exe");
	    driver = new ChromeDriver();			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");	
	}
	
	@After
	public void tearDown() {
		System.out.println("This is After class");
		driver.close();	
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		System.out.println("This is before Test1");
		//identify elements
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);					
	}
	
	@Test
	public void loginTestNegative() throws InterruptedException {
		System.out.println("This is before Test2");
		//identify elements
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123234");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
					
	}

	
	
	

}
