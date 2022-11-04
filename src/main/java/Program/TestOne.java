package Program;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.amazon.project.XLXXReader;

public class TestOne {
	
	static String value = "Books";
	static String searchvalue = "Ponniyin Selvan";
	
	public static void main(String[] args) throws InterruptedException, Exception {
		
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\TME\\eclipse-Selenium\\AmazonProject\\Driver\\chromedriver.exe");
	  
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://www.amazon.in/");
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
	  dropdown.click();
	  
//      String value = XLXXReader.particularData("amazon",1,0);	  
	  
	  Select s = new Select(dropdown);
	  
	  List<WebElement> options = s.getOptions();
	  
	  for (int i=0;i<options.size();i++) {
		String actual = options.get(i).getText();
//		System.out.println(actual);
		
		if (value.equals(actual)) {
			s.selectByVisibleText(actual);
		}
	  }
		
//	   String searchvalue = XLXXReader.particularData("amazon", 1, 1);
	  
	   WebElement search = driver.findElement(By.xpath("//select/ancestor::div[3]/following-sibling::div[1]/div[1]/input"));
		search.sendKeys(searchvalue);
		
		List<WebElement> searchoptions = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']"));
		int count = searchoptions.size();
//	    System.out.println(count);
	    
		for (int i = 1; i <=count; i++) {
			
//			int svalue = count-2;
			
			Thread.sleep(3000);
			
			WebElement results = driver.findElement(By.xpath("//div[@class='autocomplete-results-container']/div["+i+"]"));
			String a = results.getText();
			
			if(searchvalue.equalsIgnoreCase(a)) {
				results.click();
				break;
			}else {
				continue;
			}
		}
	 System.out.println("Completed");
	}

}
