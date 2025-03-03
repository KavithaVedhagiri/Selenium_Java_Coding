package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingSlider {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		
		WebElement minSlider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		System.out.println("Loction of min slider :" + minSlider.getLocation());
		act.dragAndDropBy(minSlider,-100, 1973).perform();
		System.out.println("Loction of min slider :" + minSlider.getLocation());
		
		
		WebElement maxSlider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		System.out.println("Loction of max slider :" + maxSlider.getLocation());
		act.dragAndDropBy(maxSlider,100,1502).perform();
		System.out.println("Loction of max slider :" + maxSlider.getLocation());

		
		
	
		
		Thread.sleep(3000);
		driver.quit();

	}

}
