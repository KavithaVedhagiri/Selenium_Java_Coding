package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
//	    WebElement paginationcheckboxbtn  = driver.findElement(By.xpath("//table//input[@type='checkbox'][1]"));
//	    paginationcheckboxbtn.click();
        
        
        List<WebElement> pagelists = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
    		    for (WebElement pageList : pagelists) {
          		pageList.click();
          		Thread.sleep(1000);
                List<WebElement> paginationcheckboxsbtn = driver.findElements(By.xpath("//table//input[@type='checkbox']"));
          		 for (int i = 0;i<paginationcheckboxsbtn.size();i++) {
           		  paginationcheckboxsbtn.get(i).click();
          }
    	    }
    	driver.quit();
        	
	}

}
