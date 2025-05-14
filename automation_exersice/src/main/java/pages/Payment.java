package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payment extends PageBase {
	public Payment(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[1]/div/input")
	public WebElement nameONcard;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[2]/div/input")
	public WebElement cardNumber;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[1]/input")
	public WebElement cvc;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[2]/input")
	public WebElement expiryMonth;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[3]/div[3]/input")
	public WebElement expiryYear;
	@FindBy(id="submit")
	public WebElement payANDconfirmBtn;
	
	public void userCanPay() {
		nameONcard.sendKeys("amira");
		cardNumber.sendKeys("1452025");
		cvc.sendKeys("222");
		expiryMonth.sendKeys("09");
		expiryYear.sendKeys("2030");
		payANDconfirmBtn.click();
	}
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/p")
	public WebElement placedMessage;
    

}
