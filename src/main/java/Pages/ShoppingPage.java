package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingPage {
WebDriver driver;

@FindBy(name="search")
WebElement searchfield;

@FindBy(id="_undefined")
WebElement searchbrand;

@FindBy(xpath="//*[@id=\"scroll-container\"]/div/div[1]//li/label")
WebElement brand;

@FindBy(xpath="//*[@id=\"68732665\"]//div[4]/div/button")
WebElement watch1;

@FindBy(xpath="//*[@id=\"shopfront-app\"]//div[2]/div[3]/button")
WebElement loadmore;

@FindBy(xpath="//*[@id=\"46911729\"]//div[4]/div/button")
WebElement watch2;

@FindBy(xpath="//*[@id=\"shopfront-app\"]/div[3]//div/button")
WebElement cart;

@FindBy(xpath="//*[@id=\"shopfront-app\"]//section/div[2]/div[1]/div[1]")
WebElement cartpage;


public ShoppingPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void SearchProduct(String product) {
	searchfield.sendKeys(product);
}

public void Enter() {
searchfield.sendKeys(Keys.ENTER);
}


public void SelectBrand() {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	searchbrand.sendKeys("garmin");
    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", brand);
		
}

public void selectFirstWatch() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element1=wait.until(ExpectedConditions.elementToBeClickable(watch1));
	((JavascriptExecutor)driver).executeScript("arguments[0].click();",element1);
	
}

public void loadMore()
{
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement load=wait.until(ExpectedConditions.elementToBeClickable(loadmore));
	((JavascriptExecutor)driver).executeScript("arguments[0].click();",load);
}

public void selectSecondWatch() {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element2=wait.until(ExpectedConditions.elementToBeClickable(watch2));
	((JavascriptExecutor)driver).executeScript("arguments[0].click();",element2);
	
}

public void verifyCart() {
	cart.click();
	boolean cartvalue=cartpage.getText().contains("Garmin QuickFit 26mm Silicone")&&cartpage.getText().contains("Garmin Forerunner 45S Sports");
	System.out.println(cartvalue);
	System.out.println(" 2 products successfully addded");
	

}

}
