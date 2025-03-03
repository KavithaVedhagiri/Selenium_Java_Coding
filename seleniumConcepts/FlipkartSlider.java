package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSlider {

	public static void main(String[] args) {
	  WebDriver driver = new ChromeDriver();
	    driver.get("https://www.flipkart.com/");  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement slider =  driver.findElement(By.xpath("//button[@title='Previous Slide']"));
		slider.click();

	}

}
