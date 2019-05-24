package com.tr.object;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject {


	@FindBy(id="twotabsearchtextbox")
	WebElement SearchBox;
	
	@FindBy(className ="nav-input")
	WebElement Search;
	
	//burada kaldım..saati tıklatıp sepete ekleyeceğim
	
	//*[@id="search"]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[1]
	@FindBy(xpath="//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[1]")
	WebElement Filter1;
	
	@FindBy(id="soldByThirdPartyRelocate_feature_div")
	WebElement SortBy;
	
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	public WebElement SearchBox()
	{
		return SearchBox;
	}

	public WebElement Search()
	{
		return Search;
	}

	public WebElement Filter1()
	{
		return Filter1;
	}
	public WebElement SortBy()
	{
		return SortBy;
	}
	public void dropdown()
	{
		//WebDriverWait wd=new WebDriverWait(driver,5);
		//wd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='m_frmRegister']/div[1]/ul")));
		Select dropdown=new Select(SortBy());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		dropdown.selectByVisibleText("Price: High to Low");
	}
}
