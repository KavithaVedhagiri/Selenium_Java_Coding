package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDropDownWithoutSelectClass1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//select[@id='country']")).sendKeys("United Kingdom");
		driver.findElement(By.xpath("//select[@id='colors']")).sendKeys("White");
	    driver.findElement(By.xpath("//select[@id='animals']")).sendKeys("Dog");
		
	}

}
