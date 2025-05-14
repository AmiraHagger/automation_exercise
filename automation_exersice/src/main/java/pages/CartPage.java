package pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
	public WebElement subscribtionExist;
	@FindBy(id = "susbscribe_email")
	public WebElement subscribtion;
	@FindBy(id = "subscribe")
	WebElement submit;
	@FindBy(id="success-subscribe")
	public WebElement subscribeMessage;
    @FindBy(css="#footer")
    public WebElement footer;
	
	public void userCanSubscribe() {
		subscribtion.sendKeys("amira.hagger@gmail.com");
		submit.click();
	}

	@FindBy(className = "cart_product")
    public  List<WebElement> cartItems ;
	
	
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[3]/p")
	public WebElement actualFirstProductPrice;
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[4]/button")
	public WebElement actualFirstProductQuantity;
	@FindBy(xpath = "//*[@id=\"product-1\"]/td[5]/p")
	public WebElement actualFirstProductTotal;
	
	
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[3]/p")
	public WebElement actualSecondProductPrice;
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[4]/button")
	public WebElement actualSecondProductQuantity;
	@FindBy(xpath = "//*[@id=\"product-2\"]/td[5]/p")
	public WebElement actualSecondProductTotal;
	
	
	@FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
    public WebElement checkOutBtn;
	
    public void ProcessedTOcheckout() {
    	checkOutBtn.click();
    }
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[2]/h2")
    public WebElement AddressDetails;
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[4]/h2")
    public WebElement ReviiewYourOrder;
    @FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
    public WebElement descriptionTxt;
    public void addDescriotion() {
    	descriptionTxt.sendKeys("call me before delivery arrival.");
    }
    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
    public WebElement placeOrderBtn;
    
    public void placeOrder() {
    	placeOrderBtn.click();
    }
	
	

}


