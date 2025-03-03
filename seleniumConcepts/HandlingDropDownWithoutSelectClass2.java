package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDropDownWithoutSelectClass2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		String option = "United Kingdom";
		
		WebElement countryDrapDowns = driver.findElement(By.xpath("//select"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = 'uk'", countryDrapDowns);
		
		driver.findElement(By.xpath("//select[@id='colors']")).click();
		WebElement colorsDrapDown1 = driver.findElement(By.xpath("//select[@id='colors']//option"));
		js.executeScript("arguments[0].value = 'blue'",colorsDrapDown1);
	
		
		WebElement animalDrapDown = driver.findElement(By.xpath("//select[@id='animals']"));
		js.executeScript("arguments[0].value = 'dog'",animalDrapDown);
		
	}

}
