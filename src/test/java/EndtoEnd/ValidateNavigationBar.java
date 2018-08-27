package EndtoEnd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Resources.base;

public class ValidateNavigationBar extends base {
	public static Logger Log=LogManager.getLogger(ValidateNavigationBar.class.getName());
	@Test
	public void basepagenavigation() throws IOException{
	   d=initializeDriver();
	   d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get(base.getUrl());
		pageObject.Landingpage Lp = new pageObject.Landingpage(d);
		Assert.assertTrue(Lp.getnavbar().isDisplayed());
		Log.info("Check if element is displayed");
		
	}
	@AfterTest
	public void closeDriver(){
		d.close();
		d=null;
	}
	
	
}
