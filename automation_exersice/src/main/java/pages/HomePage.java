package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Home")
	public WebElement homeLink;
	@FindBy(linkText = "Cart")
	public WebElement CartBtn;
	@FindBy(xpath  = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	public WebElement ProductsBtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	public WebElement LoginBtn;
	public void openCartPage() {
		CartBtn.click();
	}
	public void openProductsPage() {
		ProductsBtn.click();
	}   
	public void openLoginPage() {
		LoginBtn.click();
	}
	
	@FindBy(linkText ="View Product")
	public WebElement viewProductBtn;
    
	public void openProductDetails() {
		viewProductBtn.click();
	}}
