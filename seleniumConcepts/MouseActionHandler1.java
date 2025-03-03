package seleniumConcepts;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionHandler1 {

	public static void main(String[] args) {
 
		WebDriver driver = new ChromeDriver();
//		driver.get("https://demo.opencart.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		WebElement desktop = driver.findElement(By.xpath("//a[normalize-space() = 'Desktops']"));
//		WebElement mac = driver.findElement(By.xpath("//a[normalize-space() = 'Mac (1)']"));
		
		//moveToElement = hover
		
		//Actions -- class,will be used to perform mouse action
        //Action -- interface will be used to store created actions
		
		Actions act = new Actions(driver);
//		act.moveToElement(desktop).moveToElement(mac).click().perform();
		
		
		//contentlick = rightClick
		
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement rightClickElement = driver.findElement(By.xpath("//span[normalize-space() = 'right click me']"));
		act.contextClick(rightClickElement).perform();
		WebElement copyValue = driver.findElement(By.xpath("//ul//span[text() = 'Copy']"));
		copyValue.click();
		Alert acceptAlert = driver.switchTo().alert();
		acceptAlert.accept();
		
	    
	}

}
