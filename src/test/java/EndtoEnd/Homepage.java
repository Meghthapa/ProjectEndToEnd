package EndtoEnd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import Resources.base;

public class Homepage extends base {
	public static Logger Log=LogManager.getLogger(Homepage.class.getName());
	
	@BeforeTest
	public void start() throws IOException{
	d=initializeDriver();
	Log.info("Driver is initialized");
	  	   d.get(base.getUrl());
	  	 Log.info("Opening a browser");
	  	 d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  	
	  	 
			
	
	}
	
	@Test(dataProvider="getData")
	public void basepagenavigation(String username,String password) throws IOException{
		
		Landingpage Lp = new Landingpage(d);
		
		//Lp.dismissAlert().click(); 		
	    d.findElement(By.linkText("Login")).click();
		Lp.getEmail().sendKeys(username);
		Lp.getPassword().sendKeys(password);
		Lp.clickSubmit().click();
		//System.out.println(text);
		Log.info("Sending a usename and password");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[1][2];
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
//		data[0][2]="Non restricted user";
//		
//		data[1][0]="restricteduser@qw.com";
//		data[1][1]="456788";
//		data[1][2]="Restricted user";
		
		return data;
	}
	
	@AfterTest
	public void quit(){
		d.quit();
		d=null;
	}
	
}
