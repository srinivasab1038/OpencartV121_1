package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmpassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkboxPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmationmsg;

public void enterFirstname(String Fname)
{
	txtFirstname.sendKeys(Fname);
}

public void enterLastName(String Lname)
{
	txtLastname.sendKeys(Lname);
}

public void enterEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void enterTelephone(String tele)
{
	txtTelephone.sendKeys(tele);
}


public void enterPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void enterConfirmpassword(String Confirmpwd)
{
	txtConfirmpassword.sendKeys(Confirmpwd);
}

public void tickPrivacypolicy()
{
	chkboxPolicy.click();
}

public void clickContinue()
{
	//sol 1
	btnContinue.click();
	
	//sol 2
	//btnContinue.submit();
	
	//sol 3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
	
	//sol 4
	//JavascriptExecutor js= (JavascriptExecutor) driver;
	//js.executeScript("argument[0].click();",btnContinue);
	
	//sol 5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//sol 6
	//WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
}
	public String getConfirmationmsg()
	{
		try {
			return (msgConfirmationmsg.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}

}
