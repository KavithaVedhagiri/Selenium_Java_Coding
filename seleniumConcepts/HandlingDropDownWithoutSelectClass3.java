package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HandlingDropDownWithoutSelectClass3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='country']"));
		Actions action = new Actions(driver);
		action.moveToElement(dropDown).perform();
		driver.findElement(By.xpath("//option[contains(text(),'France')]")).click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://testautomationpractice.blogspot.com/");
		
		WebElement drapDown1 = driver.findElement(By.xpath("//select[@id='colors']"));
		Actions act = new Actions(driver);
		act.moveToElement(drapDown1).perform();
		driver.findElement(By.xpath("//option[contains(text(),'Blue')]")).click();
		
		WebElement drapDown2 = driver.findElement(By.xpath("//select[@id='animals']"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(drapDown2).perform();
		driver.findElement(By.xpath("//option[contains(text(),'Elephant')]")).click();
		
		
	}
}
