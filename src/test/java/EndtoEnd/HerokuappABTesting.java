package EndtoEnd;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class HerokuappABTesting {
	
	
	String prop=System.setProperty("webdriver.chrome.driver", "C:\\Users\\meght\\Desktop\\chromedriver.exe");
	WebDriver driver;
	File folder;
	 
	
	@Test(enabled=false)
	public void ABTesting(){
		
		driver= new ChromeDriver();
		 driver.get("http://the-internet.herokuapp.com/");
		 driver.findElement(By.linkText("A/B Testing")).click();
		 System.out.println(driver.getTitle());
		 driver.navigate().back();
		 
	}
	
	@Test
	public void BasicAuth() throws InterruptedException{
				
		driver= new ChromeDriver();
		 driver.get("http://the-internet.herokuapp.com/key_presses");
		 Actions action= new Actions(driver);
		 action.sendKeys(Keys.SHIFT.UP).build().perform();
		 driver.manage().window().maximize();
		 String text = driver.findElement(By.id("result")).getText(); 
		 Assert.assertEquals(text,"You entered: ADD" );
		 				 		 		
	}
     @Test
     public void downloadfile(){
    	 folder= new File(UUID.randomUUID().toString());
    	 folder.mkdirs();
    	 
    	 String prop=System.setProperty("webdriver.chrome.driver", "C:\\Users\\meght\\Desktop\\chromedriver.exe");
    	 ChromeOptions option = new ChromeOptions();
    	 
    	 Map<String,Object> prefs = new HashMap<String,Object>();
    	 prefs.put("profile.default_content_settings.popups", 0);
    	 prefs.put("download.default.directory", folder.getAbsolutePath());
    	 
    	 option.setExperimentalOption("prefs", prefs);
    	 
    	 DesiredCapabilities cap = DesiredCapabilities.chrome();
    	 cap.setCapability(ChromeOptions.CAPABILITY, option);
    	 
    	 driver= new ChromeDriver(cap);
    	 
    	 
     }
     @Test
     public void downloadFile() throws InterruptedException{
    	 driver.get("http://the-internet.herokuapp.com/download");
    	 Thread.sleep(2000);
    	 driver.findElement(By.linkText("IMG_0719.JPG ")).click();
    	 
    	 Thread.sleep(2000);
    	 File listoffile[]=folder.listFiles();
    	 Assert.assertTrue(listoffile.length>0);
    	 
     }
     
//     @AfterMethod
//     public void teardown(){
//    	 driver.quit();
//    	 for(File file:folder.listFiles()){
//    		 file.delete();
//    		 
//    	 }
//    	 folder.delete();
//    	 
//     }
}
