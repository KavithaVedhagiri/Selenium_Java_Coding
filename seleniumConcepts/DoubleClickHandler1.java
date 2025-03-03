package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickHandler1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement copyText = driver.findElement(By.xpath("//button[normalize-space()= 'Copy Text']"));
		
		field1.clear();
		field1.sendKeys("Welcome");
		Actions act = new Actions(driver);
		act.doubleClick(copyText).perform();
		
        String text = field2.getAttribute("value");
        if(text.equals("Welcome")) {
        	System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
        Thread.sleep(2000);
        
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropElement = driver.findElement(By.xpath("//div[@id='droppable']"));
        
        Actions action = new Actions(driver);
        action.dragAndDrop(dragElement, dropElement).perform();
	}

}
