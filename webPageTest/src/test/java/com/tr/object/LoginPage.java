package com.tr.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
	
	//*[@id="nav-link-yourAccount"]
	
	@FindBy(id="nav-link-accountList")
	//@FindBy(xpath="//*[@id=/"nav-link-accountList"/]/span[1]")
	//*[@id="nav-link-accountList"]
	//*[@id="nav-flyout-ya-signin"]/a/span
	//document.querySelector("#nav-flyout-ya-signin > a > span")
	WebElement Account;
	
	//@FindBy(className="nav-action-button")
	
	//@FindBy(id="nav-link-yourAccount")
	@FindBy(id="nav-link-accountList")
	public
	WebElement SignIn;
	
	@FindBy(name="email")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(id="signInSubmit")
	WebElement Submit;
	
	public LoginPage(WebDriver driver)
	{
	super(driver);
	}
	
	public WebElement Account()
	{
		return Account;
	}
	
	public WebElement SignIn()
	{
		return SignIn;
	}
	
	public WebElement Username()
	{
		return Username;
	}
	
	public WebElement Password()
	{
		return Password;
	}
	
	public WebElement Submit()
	{
		return Submit;
	}
	

}
