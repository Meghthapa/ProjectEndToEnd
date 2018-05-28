package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class base {
	public static WebDriver d;
	public static Properties prop;
	public WebDriver initializeDriver() throws IOException{
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\meght\\ProjectEndtoEnd\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\meght\\Desktop\\chromedriver.exe");
		 d= new ChromeDriver();
		
		}else if(browserName.equals("firefox")){
			d= new FirefoxDriver();
		}else if(browserName.equals("ie")){
			d= new InternetExplorerDriver();
		}
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return d;
	}
	
	public static String getUrl() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\meght\\ProjectEndtoEnd\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String url=prop.getProperty("URL");
		return url;
	}
	public static void getScreenshot(String result) throws IOException{
	File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE); 
	File destFolder=new File("C:\\Users\\meght\\"+result+"seleniumscreenshot.png");
	FileHandler.copy(src,destFolder);
	}
	
	

}
