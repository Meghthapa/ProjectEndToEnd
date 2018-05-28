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

public class ValidateTitle extends base {
	public static Logger Log=LogManager.getLogger(ValidateTitle.class.getName());
	@Test
	public void basepagenavigation() throws IOException{
	   d=initializeDriver();
	   d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   d.get(base.getUrl());
		String title = d.getTitle();
		Landingpage Lp = new Landingpage(d);
		String text=Lp.getText().getText();
		System.out.println(text);
		System.out.println(title);
		Assert.assertEquals(title, "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		Assert.assertEquals(text, "FEATURED COURSES");
		Log.info("Sucessfully validated title");
		
		
	}
	@AfterTest
	public void closeDriver(){
		d.close();
		d=null;
	}
	
	
}
