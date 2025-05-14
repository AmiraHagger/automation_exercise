package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(name="email")
	WebElement emailTxt;
	
	@FindBy(name="password")
	WebElement passwordTxt;
	
	@FindBy(css="#form > div > div > div.col-sm-4.col-sm-offset-1 > div.login-form > form > button")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
	public WebElement loginMessage;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	public WebElement deleteAccountBtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/p[1]")
	public WebElement deletedMessage;
	
	public void userCanLogin(String email,String password) {
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		loginBtn.click();
	}

	public void deleteAccount() {
		deleteAccountBtn.click();
	}

	
}


