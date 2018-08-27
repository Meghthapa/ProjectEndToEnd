package EndtoEnd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingDynamicTables {

	public static void main(String[] args) {
		 String prop=System.setProperty("webdriver.chrome.driver", "C:\\Users\\meght\\Desktop\\chromedriver.exe");
    	 WebDriver d = new ChromeDriver();
         d.get("https://www.w3schools.com/Html/html_tables.asp");
         
         List<WebElement> list=d.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
         int rowCount=list.size();
         System.out.println("total rows int the table are :"+rowCount);
         
       //*[@id="customers"]/tbody/tr[2]/td[1]
       //*[@id="customers"]/tbody/tr[7]/td[1]
         
         String beforexpath=" //*[@id='customers']/tbody/tr[";
         String afterxpath="]/td[1]";
         
         for(int i=2;i<=rowCount;i++){
        	 String actualXpath=beforexpath+i+afterxpath;
        	 WebElement element = d.findElement(By.xpath(actualXpath));
        	 System.out.println(element.getText());
        	 if(element.getText().equals("Centro comercial Moctezuma")){
        		 System.out.println("Company is found in "+element.getText()+"is found at position"+ i);
        		
        		 //Contacts
        		//*[@id="customers"]/tbody/tr[2]/td[2]
        		//*[@id="customers"]/tbody/tr[7]/td[2]
        		 String contactBeforexpath="//*[@id='customers']/tbody/tr[";
        		 String contactAfterxpath="]/td[2]";
        		 for(int c=2;c<=rowCount;c++){
                  String fullXpath = contactBeforexpath+c+contactAfterxpath; 
                  WebElement cxpath= d.findElement(By.xpath(fullXpath));
                  System.out.println(cxpath.getText());
                  
        		 }
        		 
        		 //country
        		//*[@id="customers"]/tbody/tr[2]/td[3]
        		//*[@id="customers"]/tbody/tr[7]/td[3] 
        		 
        		 String countryB4="//*[@id='customers']/tbody/tr[";
        		 String countryAfter ="]/td[3]";
        		 
        		 for(int j=2;j<=rowCount;j++){
        			 String fullcouxpath=countryB4+j+countryAfter;
        			 WebElement countryxpath=d.findElement(By.xpath(fullcouxpath));
        			 System.out.println(countryxpath.getText());
        		 }
        	 }
         }
	}

}
