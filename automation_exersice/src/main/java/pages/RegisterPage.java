package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends PageBase {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name="name")
	WebElement usernameTxt;

	@FindBy(name="email")
	List<WebElement> emails;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement signUpBtn;
	
	@FindBy(id="id_gender1")
	WebElement maleGenderRadioBox;
	
	@FindBy(id="password")
	WebElement passwordTxt;
	
	@FindBy(id="days")
	WebElement daysList;
	
	@FindBy(id="months")
	WebElement monthsList;
	
	@FindBy(id="years")
	WebElement yearsList;
	
	@FindBy(id="newsletter")
	WebElement newsLetterBtn;
	
	@FindBy(id="optin")
	WebElement specialOfferBtn;
	
	@FindBy(id="first_name")
	WebElement firstNameTxt;
	
	@FindBy(id="last_name")
	WebElement lastNameTxt;
	
	@FindBy(id="company")
	WebElement companyTxt;
	
	@FindBy(id="address1")
	WebElement addressTxt1;
	
	@FindBy(id="address2")
	WebElement addressTxt2;
	
	@FindBy(id="country")
	WebElement countryList;
	
	@FindBy(id="state")
	WebElement stateTxt;
	
	@FindBy(id="city")
	WebElement cityTxt;
	
	@FindBy(id="zipcode")
	WebElement zipcodeTxt;
	
	@FindBy(id="mobile_number")
	WebElement mobileNumberTxt;
	
	@FindBy(css="#form > div > div > div > div.login-form > form > button")
	WebElement createAccountBtn;	
	
	@FindBy(xpath ="//*[@id=\"form\"]/div/div/div[3]/div/h2")
	public WebElement newUserMessage;
	
	@FindBy(css="#form > div > div > div > div.login-form > h2 > b")
	public WebElement enterAccountMessage;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement successMessage;
	
	@FindBy(linkText = "Continue")
	WebElement continueBtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement logOutBtn;
	
	
	public void userCanRegister(String name ,String email) {
		usernameTxt.sendKeys(name);
		emails.get(1).sendKeys(email);
		signUpBtn.click();
	}
	
	public void enterAccountInformation(String password,int day,String month,
					String year,String firstName,String lastName,
					String company,String address1,String address2
					,int countryIndex,String state,String city,
					String zipCode,String mobilNumber) {
		maleGenderRadioBox.click();
		passwordTxt.sendKeys(password);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("let days = document.getElementById('days')\r\n"
				+ "days.scrollIntoView(\r\n"
				+ "    {\r\n"
				+ "        behaviour: \"smooth\"\r\n"
				+ "    }\r\n"
				+ ")");
		
		Select makeDaysList = new Select(daysList);
		Select makeMonthsList = new Select(monthsList);
		Select makeYearsList = new Select(yearsList);
		Select makeCountryList = new Select(countryList);
		
		makeDaysList.selectByIndex(day);
		makeMonthsList.selectByVisibleText(month);
		makeYearsList.selectByValue(year);
		
		newsLetterBtn.click();
		specialOfferBtn.click();
		
		firstNameTxt.sendKeys(firstName);
		lastNameTxt.sendKeys(lastName);
		companyTxt.sendKeys(company);
		
		addressTxt1.sendKeys(address1);
		addressTxt2.sendKeys(address2);
		
		String title =(String) js.executeScript("return document.title;");
		System.out.println(title);
		
		js.executeScript("let country = document.getElementById('country')\r\n"
				+ "country.scrollIntoView(\r\n"
				+ "    {\r\n"
				+ "        behaviour: \"smooth\"\r\n"
				+ "    }\r\n"
				+ ")");
		
		makeCountryList.selectByIndex(0);
		stateTxt.sendKeys(state);
		cityTxt.sendKeys(city);
		
		zipcodeTxt.sendKeys(zipCode);
		mobileNumberTxt.sendKeys(mobilNumber);
		
		createAccountBtn.click();
	}

		public void continueAccount() {
			continueBtn.click();
		}
		public void logOut() {
			logOutBtn.click();
		}
	
		
	}

