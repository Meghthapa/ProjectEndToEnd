package EndtoEnd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObject.Landingpage;

public class ValidateNavigationBar extends base {
	public static Logger Log=LogManager.getLogger(ValidateNavigationBar.class.getName());
	@Test
	public void basepagenavigation() throws IOException{
	   d=initializeDriver();
	   d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get(base.getUrl());
		Landingpage Lp = new Landingpage(d);
		Assert.assertTrue(Lp.getnavbar().isDisplayed());
		Log.info("Check if element is displayed");
		
	}
	@AfterTest
	public void closeDriver(){
		d.close();
		d=null;
	}
	
	
}
