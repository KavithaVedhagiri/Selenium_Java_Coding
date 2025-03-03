package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class CheckBoxedHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		List<WebElement> checkboxsclc =  driver.findElements(By.xpath("//form[@id='checkboxes']//input"));
		for (WebElement checkbox : checkboxsclc) {
			   checkbox.click();
			   for (WebElement checkbox1 : checkboxsclc) {
				   checkbox1.click();
			}
		}
		
		WebElement checkboxclc2 =  driver.findElement(By.xpath("(//form[@id='checkboxes']//input)[1]"));
		checkboxclc2.click();
		
		driver.quit();
        
	}

}
