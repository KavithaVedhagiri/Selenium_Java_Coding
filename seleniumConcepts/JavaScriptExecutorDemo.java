package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
	   WebDriver driver = new ChromeDriver();
//	   ChromeDriver driver1 = new ChromeDriver();
	   driver.get("https://testautomationpractice.blogspot.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   WebElement inputBox = driver.findElement(By.xpath("//input[@id='name']"));
	   WebElement emailInputBox = driver.findElement(By.xpath("//input[@id='email']"));
	   JavascriptExecutor js = (JavascriptExecutor)driver;
	   //if it is creating object for ChromeDriver class the no need to type cast the driver because internally it extends chromium driver that 
//	   chromium driver extends remote WebDriver it extends javascript executor so typecasting not needed.
//	   JavascriptExecutor js = driver1;
	   
	   
	   js.executeScript("arguments[0].setAttribute('value','Devesh')", inputBox);
	   js.executeScript("arguments[0].setAttribute('value','devesh@gmail.com')", emailInputBox);
	   
	   WebElement femaleButton = driver.findElement(By.xpath("//input[@id='female']"));
	   js.executeScript("arguments[0].click()", femaleButton);

	}

}
