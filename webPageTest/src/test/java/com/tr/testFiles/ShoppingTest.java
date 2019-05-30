package com.tr.testFiles;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

//import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.tr.object.LoginPage;
import org.openqa.selenium.support.ui.Select;

import com.tr.object.CartPage;
import com.tr.object.HomePage;
import com.tr.object.ItemPage;

public class ShoppingTest extends FunctionalTest {
	//giriş yapmayı sağlayan metod
	@Test(priority=1)	
	public void Login()
	{
		driver.get("https://www.amazon.com.tr/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		LoginPage lp=new LoginPage(driver);
		Assert.assertTrue(lp.Account().isDisplayed());
		Actions abc=new Actions(driver);
		abc.moveToElement(lp.Account()).build().perform();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//System.out.println(driver.findElements(By.tagName("iframe")).size());
		Assert.assertTrue(lp.SignIn().isDisplayed());
		WebDriverWait wd=new WebDriverWait(driver,5);
		//wd.until(ExpectedConditions.visibilityOf(lp.SignIn));
	//	Assert.assertTrue(lp.SignIn().isDisplayed());
		//System.out.println(driver.getPageSource());		
		lp.SignIn().click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Assert.assertTrue(lp.Username().isDisplayed());
		lp.Username().sendKeys("volkankaraman019@gmail.com");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		lp.Password().sendKeys("123456asdfgh");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		lp.Submit().click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		
	}
	@Test(priority=2,dependsOnMethods={"Login"})
	public void AddItem()
	{
		HomePage hp=new HomePage(driver);
		hp.SearchBox().sendKeys("Akıllı Saat");
		//Assert.assertTrue(hp.Search().isDisplayed());
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		hp.Search().click();
		//Assert.assertTrue(hp.Filter1().isDisplayed());
		//	System.out.println("Clicked");
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		//Assert.assertTrue(hp.SortBy().isDisplayed());
		hp.Filter1().click();		
		ItemPage ip=new ItemPage(driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		boolean butonDurum = driver.findElement(By.linkText("Sepete Ekle")).isDisplayed();
		System.out.println("durum"+butonDurum);
		//Click on the 1st Item to be added to the cart		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		ip.AddToCart().click();
		
		
		
	}
	
	@Test(priority=3,dependsOnMethods={"AddItem"})
	public void CheckCart()
	{        
		CartPage cp = new CartPage(driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String gelenDeger = cp.UrunAdet().getText();
		System.out.println("gelen dEğer"+gelenDeger);
		int deger = Integer.parseInt(gelenDeger);
		System.out.println("gelen dEğer"+deger);
        if (deger>0) {
			cp.SatinAl().click();
		}
		
	}
	@AfterTest
	public void Cikis(){
		
		driver.quit();
		
	}
	
	
	
}
