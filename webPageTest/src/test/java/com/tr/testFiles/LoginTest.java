package com.tr.testFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tr.object.LoginPage;

public class LoginTest extends FunctionalTest {
	
	@Test
	public void Login()
	{
		driver.get("https://www.amazon.com.tr/");
		
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.Account().isDisplayed());
		Actions abc=new Actions(driver);
		abc.moveToElement(lp.Account()).build().perform();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		Assert.assertTrue(lp.SignIn().isDisplayed());
		WebDriverWait wd=new WebDriverWait(driver,5);
		wd.until(ExpectedConditions.visibilityOf(lp.SignIn));
		Assert.assertTrue(lp.SignIn().isDisplayed());
		//System.out.println(driver.getPageSource());
		lp.SignIn().click();
		driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
		Assert.assertTrue(lp.Username().isDisplayed());
		lp.Username().sendKeys("volkankaraman019@gmail.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		lp.Password().sendKeys("123456asdfgh");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		lp.Submit().click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		
	}
	
	@AfterTest
	public void Cikis(){
		
		driver.quit();
		
	}
}
