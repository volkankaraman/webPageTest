package com.tr.testFiles;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.tr.object.BreakLinkPage;
import com.tr.object.LoginPage;

public class BreakLinkTest extends FunctionalTest{

	
	//giriş yapmayı sağlayan metod
	

		
		@Test(priority=1)	
		public void Login()
		{
			driver.get("https://www.amazon.com.tr/");
			
			LoginPage lp=new LoginPage(driver);
			Assert.assertTrue(lp.Account().isDisplayed());
			Actions abc=new Actions(driver);
			abc.moveToElement(lp.Account()).build().perform();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			//System.out.println(driver.findElements(By.tagName("iframe")).size());
			Assert.assertTrue(lp.SignIn().isDisplayed());
			WebDriverWait wd=new WebDriverWait(driver,5);
			wd.until(ExpectedConditions.visibilityOf(lp.SignIn));
			Assert.assertTrue(lp.SignIn().isDisplayed());
			//System.out.println(driver.getPageSource());
			lp.SignIn().click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			Assert.assertTrue(lp.Username().isDisplayed());
			lp.Username().sendKeys("volkankaraman019@gmail.com");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			lp.Password().sendKeys("123456asdfgh");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			lp.Submit().click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
			
			
			
		}
		@Test(priority=2,dependsOnMethods={"Login"})
		private void linkDurum() {
			BreakLinkPage blp = new BreakLinkPage(driver);
			System.out.println("geleln linkler Sayısı"+blp.BreakLinks().size());
			
			for(int i=0;i<blp.BreakLinks().size();i++)
			{
				
				WebElement ele= blp.BreakLinks().get(i);
				
				String url=ele.getAttribute("href");
				String testURL="https://www.amazone.com.tr/?node=16269149031&pf_rd_p=9cd20204-19bb-4f02-8681-51dda7985412&pf_rd_r=";
				
				verifyLinkActive(url);
				
			}

		}
		
		
		
		public static void verifyLinkActive(String linkUrl)
		{
	        try 
	        {
	           URL url = new URL(linkUrl);
	           
	           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
	           
	           httpURLConnect.setConnectTimeout(3000);
	           
	           httpURLConnect.connect();
	           System.out.println("gelen Mesaj"+httpURLConnect.getResponseMessage());
	          
	           if(httpURLConnect.getResponseCode()==200)
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	               Assert.assertEquals(httpURLConnect.getResponseMessage(),"OK");
	            }
	          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
	           {
	               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
	               Assert.assertEquals(httpURLConnect.getResponseMessage(),"OK");
	            }
	          else{
	        	  System.out.println("gelen Mesaj"+httpURLConnect.getResponseCode());
	          }
	        } catch (Exception e) {
	        	System.out.println("gelen hata"+e);
	        	
	           
	        }
		}
}
