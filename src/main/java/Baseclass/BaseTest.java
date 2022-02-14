package Baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ShoppingPage;
import Pages.SignupPage;

public class BaseTest {
String driverpath= "D:\\chromedriver_win32\\chromedriver.exe";
WebDriver driver;
SignupPage Snpage;
ShoppingPage shop;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.takealot.com");
		driver.manage().window().maximize();
	}
	
	@Test(priority=0)
	public void test_signup() {
		SignupPage Snpage=new SignupPage(driver);
		Snpage.register();
		
		Snpage.setFirstname("test");
		Snpage.setLastname("123");
		Snpage.setEmail("testerswa22@gmail.com");
		Snpage.resendEmail("testerswa22@gmail.com");
		Snpage.setPassword("tesing123");
		Snpage.confirmPassword("tesing123");
		Snpage.setmobile("07776602765");
		Snpage.confirmbutton();
		Snpage.getSignInVerify();
		Snpage.shoppinglink();
	} 
	
	@Test(priority=1)
	public void test_shopping() {
		ShoppingPage shop=new ShoppingPage(driver);	
		shop.SearchProduct("watches");
		shop.Enter();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		shop.SelectBrand();
		shop.selectFirstWatch();
		shop.loadMore();
		shop.selectSecondWatch();
		shop.verifyCart();
		
	}
	
	@AfterTest
	public void test_complet() {
		driver.quit();
	}
	
}
