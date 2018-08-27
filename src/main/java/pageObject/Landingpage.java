package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	public WebDriver d;
	public Landingpage(WebDriver d){
		this.d=d;
		
	}
  
	
	
	By Email=By.xpath("//input[@name='user[email]']");
	By Password =By.xpath("//input[@name='user[password]']");
	By Submit = By.xpath("//input[@name='commit']");
	By title=By.xpath("//h2[text()='Featured Courses']");
	By navbar =By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	By alert =By.xpath("//button[text()='NO THANKS']");
	
	
	public WebElement getEmail(){
		return d.findElement(Email);
	}
	
	public WebElement getPassword(){
		return d.findElement(Password);
	}
	
	public WebElement clickSubmit(){
		return d.findElement(Submit);
	}
	public WebElement getText(){
	  return d.findElement(title);
	}
	public WebElement getnavbar(){
	 return d.findElement(navbar);	
	}
	public WebElement dismissAlert(){
		return d.findElement(alert);
	}
}
