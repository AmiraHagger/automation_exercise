package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class SubscriptionINcart extends TestBase {
	HomePage homeObject;
    CartPage cartObject;

  @Test
	  public void subscribtion_mail() throws InterruptedException {

		    Assert.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color")); ;
		    homeObject.openCartPage();
		    Assert.assertEquals("rgba(255, 165, 0, 1)", homeObject.CartBtn.getCssValue("color")); ;  
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();",cartObject.footer);
		    Assert.assertEquals("SUBSCRIPTION",cartObject.subscribtionExist.getText());
		    cartObject.userCanSubscribe();
		    Assert.assertEquals("You have been successfully subscribed!",cartObject.subscribeMessage.getText());
		  
}

  @BeforeClass
  public void setUp() {
      homeObject = new HomePage(driver);
      cartObject = new CartPage(driver);
  }
}
