package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddProductsToCart extends TestBase{
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
  public void verifyAdding() throws InterruptedException {
      
	  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color")); ;
	  homeObject.openProductsPage();
	  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.ProductsBtn.getCssValue("color")); ;
	  Thread.sleep(2000);
	  hideAd();
	  productObject.hoverOvearANDaddFirstProduct();
	  Thread.sleep(2000);
	  productObject.continueShopping(); 
	  hideAd();
	  productObject.hoverOvearANDaddSecondProduct(); 
	  Thread.sleep(2000);
	  productObject.viewCart();
	  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.CartBtn.getCssValue("color")); ;
	  hideAd();
      Assert.assertEquals(cartObject.cartItems.size(), 2, "Number of products in cart doesn't match");;
      // Compare first product
      Assert.assertEquals(cartObject.actualFirstProductPrice.getText(), "Rs. 500");
      Assert.assertEquals(cartObject.actualFirstProductQuantity.getText(), "1");
      Assert.assertEquals(cartObject.actualFirstProductTotal.getText(), "Rs. 500");
 
      // Compare second product
      Assert.assertEquals(cartObject.actualSecondProductPrice.getText(), "Rs. 400");
      Assert.assertEquals(cartObject.actualFirstProductQuantity.getText(),"1");
      Assert.assertEquals(cartObject.actualSecondProductTotal.getText(), "Rs. 400");
  }
  

}
