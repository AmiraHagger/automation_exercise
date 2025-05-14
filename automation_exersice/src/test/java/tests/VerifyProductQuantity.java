package tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class VerifyProductQuantity extends TestBase {
	HomePage homeObject;
    CartPage cartObject;
    ProductsPage productObject;
   

    @BeforeClass
    public void setUp() {
        homeObject = new HomePage(driver);
        cartObject = new CartPage(driver);
        productObject=new ProductsPage(driver);
        
    }

  @Test
  public void productQuantity() throws InterruptedException {
	  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color")); ;

	  Thread.sleep(2000);
	  hideAd();
	  homeObject.openProductDetails();
	  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.ProductsBtn.getCssValue("color")); ;
	  productObject.increaseQuantity();
	  Thread.sleep(1000);
	  productObject.addTOcart();
	  Thread.sleep(1000);
	  productObject.viewCart(); 
	  Assert.assertEquals(cartObject.cartItems.size(), 1);
	  Assert.assertEquals(cartObject.actualFirstProductQuantity.getText(), "4");
  }
}
