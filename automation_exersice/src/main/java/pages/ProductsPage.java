package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage extends PageBase{

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	 @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div")
	public WebElement firstProductIMG;

	 @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a")
	public WebElement firstProduct;

	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
	public WebElement continueBtn;
	
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div")
	public WebElement secondProductIMG;

	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a")
	public WebElement secondProduct;
	
	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
	public WebElement viewCartBtn;
	
	

	
	public void hoverOvearANDaddFirstProduct() {
		 Actions actions = new Actions(driver);
		    actions.moveToElement(firstProductIMG).click().perform();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	    wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
	}
	

	public void continueShopping() {
		continueBtn.click();
	}
	public void hoverOvearANDaddSecondProduct() {
		 Actions actions = new Actions(driver);
		    actions.moveToElement(secondProductIMG).click().perform();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	    wait.until(ExpectedConditions.elementToBeClickable(secondProduct)).click();
	}
	
	public void viewCart() { 
		viewCartBtn.click();
	}

     @FindBy(id = "quantity")
     public WebElement quantityBtn;
     
     public void increaseQuantity() {
    	 quantityBtn.clear();
    	 quantityBtn.sendKeys("4");
     }
    	 
    	 @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
    	 public WebElement addTOcart;
    	 
    	 public void addTOcart() {
    		 addTOcart.click(); 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
     }

   

