package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignupPage {
	
	WebDriver driver;
	
	@FindBy(linkText="Register")
	WebElement Registerlink;
	
	@FindBy(id="firstname")
	WebElement fname;
	
	@FindBy(id="surname")
	WebElement lname;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="email2")
	WebElement Retypeemail;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password2")
	WebElement conpassowrd;
	
	@FindBy(id="telno1")
	WebElement mobile;
	
	@FindBy(name="registerButton")
	WebElement registerbutton;
	
	
	@FindBy(id="welcome")
	WebElement Confirmpopup;
	
	@FindBy(linkText="here")
	WebElement shoppinglink;
	
	
	

	public SignupPage(WebDriver driver)
	{
	this.driver=driver;
	
	
    PageFactory.initElements(driver, this);
	}
	
	public void register() {
		Registerlink.click();
	}
	
	public void setFirstname(String firstname) {
		fname.sendKeys(firstname);
	}
	
	public void setLastname(String lastname) {
		lname.sendKeys(lastname);
	}
	
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void resendEmail(String email2) {
		Retypeemail.sendKeys(email2);
	}
	
	public void setPassword(String pw) {
		password.sendKeys(pw);
	}
	
	public void confirmPassword(String pw2) {
		conpassowrd.sendKeys(pw2);
	}
	
	public void setmobile(String phone) {
		mobile.sendKeys(phone);
	}
	
	public void confirmbutton() {
		registerbutton.click();
		
	}
	

    public void getSignInVerify(){
     String confirmtext=Confirmpopup.getText();
          Assert.assertTrue(confirmtext.contains("Welcome"));
     System.out.println("Succesfully Registerted");

    }
    
    public void shoppinglink() {
    	shoppinglink.click();
    }
}
