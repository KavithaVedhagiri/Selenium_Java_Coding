package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> totalColms = driver.findElements(By.xpath("//table[@id='productTable']//th"));
        System.out.println(totalColms.size());
        
        List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='productTable']//tr"));
        System.out.println(totalRows.size());
        
//        driver.findElement(By.xpath("//table[@id='productTable']//tr[3]//td[4]//input[@type='checkbox']")).click();
        
        for(int i= 1;i<totalRows.size();i++) {
        		List<WebElement> pageNumbers = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
        		for(WebElement pageNumber :pageNumbers ) {
        			pageNumber.click();
        			Thread.sleep(3000);
            		driver.findElement(By.xpath("//table[@id='productTable']//tr["+i+"]//td[4]//input[@type='checkbox']")).click();
        			}
        		}
        }
        
	}
