package tests;

import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.Payment;
import pages.ProductsPage;
import pages.RegisterPage;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;

public class LoginBeforeChekout extends TestBase{
	HomePage homeObject;
    CartPage cartObject;
    ProductsPage productObject;
    LoginPage loginObject;
   Payment paymentObject;
   RegisterPage registerObject;

  @Test
  public void placeOrder() throws InterruptedException {
  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.homeLink.getCssValue("color")); ;
  homeObject.openLoginPage();
  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.LoginBtn.getCssValue("color")); ;
  
  Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());

  
  registerObject.userCanRegister("amira","s.d@s.d");
  
  Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());


  registerObject.enterAccountInformation("auto2025",5,"May","2002","amira"
		  ,"hagger","vois","october","mansoura",0,
		  "first","giza","3220001","01001001000");
  
  Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));

  
  registerObject.continueAccount();
  registerObject.logOut();
  
  homeObject.openLoginPage();
  AssertJUnit.assertEquals("rgba(255, 165, 0, 1)", homeObject.LoginBtn.getCssValue("color")); ;
   
  

  loginObject.userCanLogin("s.d@s.d", "auto2025");
  Assert.assertEquals(loginObject.loginMessage.getText(),"Logged in as amira" );
   
  hideAd();
  productObject.hoverOvearANDaddFirstProduct();
  Thread.sleep(1000);
  productObject.continueShopping();
  hideAd();
  productObject.hoverOvearANDaddSecondProduct();
  Thread.sleep(1000);
  productObject.viewCart();
  
  cartObject.ProcessedTOcheckout();
  Assert.assertEquals(cartObject.AddressDetails.getText(),"Address Details");
  Assert.assertEquals(cartObject.ReviiewYourOrder.getText(),"Review Your Order");

  Assert.assertEquals(cartObject.cartItems.size(), 2, "Number of products in cart doesn't match");;
  cartObject.addDescriotion();
  cartObject.placeOrder();
  paymentObject.userCanPay();
  Thread.sleep(2000);
  Assert.assertEquals(paymentObject.placedMessage.getText(), "Congratulations! Your order has been confirmed!");
  loginObject.deleteAccount();
  Assert.assertEquals(loginObject.deletedMessage.getText(),"Your account has been permanently deleted!");
  
  
	  
  }
  @BeforeClass
  public void beforeClass() {

      homeObject = new HomePage(driver);
      cartObject = new CartPage(driver);
      productObject=new ProductsPage(driver);
      loginObject=new LoginPage(driver);
      paymentObject=new Payment(driver);
      registerObject=new RegisterPage(driver);
  }

}
