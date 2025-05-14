package tests;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
    public static WebDriver driver;
    public String baseURL = "https://automationexercise.com/";

	public void hideAd() {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(
	            "var ad = document.querySelector('body > ins:nth-of-type(2)');" +
	            "if (ad) { ad.style.display = 'none'; }"
	        );
	    } catch (Exception e) {
	        System.out.println("Failed to hide ad: " + e.getMessage());
	    }
	}

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();  // moved inside method
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);

        
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
