package EndtoEnd;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.base;

public class iframeTest extends base {
	
	WebDriver driver;
	@Test
	public void IframeTe() throws IOException{
		driver = initializeDriver();
		driver.get("");
		
		
	}
	public static int SwitchFrame(WebDriver driver,By by){
		int i;
		int framecount= driver.findElements(By.tagName("iframe")).size();
		
		for(i=0;i<framecount;i++){
			driver.switchTo().frame(i);
			int count=driver.findElements(by).size();
			
			if(count>0){
				
				break;
			}else{
				System.out.println("Continue looping");
			}
		}
		driver.switchTo().defaultContent();
		return i;
	}

}
