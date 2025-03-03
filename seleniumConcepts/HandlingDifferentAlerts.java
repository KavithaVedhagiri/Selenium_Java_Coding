package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingDifferentAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement jsAlert = driver.findElement(By.xpath("//button[text()= 'Click for JS Alert']"));
		jsAlert.click();
		Alert jsAlerthandle = driver.switchTo().alert();
		Thread.sleep(1000);
		jsAlerthandle.accept();
		WebElement result1 = driver.findElement(By.xpath("//p[@id='result']"));
		String status = result1.getText();
		String expectedResult = "You successfully clicked an alert";
		Assert.assertTrue(true, expectedResult);
		Thread.sleep(3000);

		WebElement jsConfirmAlert = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		jsConfirmAlert.click();
		Alert jsConfirm = driver.switchTo().alert();
		jsConfirm.dismiss();
		WebElement result2 = driver.findElement(By.xpath("//p[@id='result']"));
		String status1 = result2.getText();
		String expectedResult1 = "You clicked: Cancel";
		if(status1.equals(expectedResult1)) {
			System.out.println("Test Passed");
		}
		else {
		    System.out.println("Test Failed");
		}
		Thread.sleep(3000);
		
		WebElement jsPrompt = driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']"));
		jsPrompt.click();
		Alert promptMessage = driver.switchTo().alert();
		promptMessage.sendKeys("Welcome");
		promptMessage.accept();
		WebElement result3 = driver.findElement(By.xpath("//p[@id='result']"));
		String status2 = result3.getText();
		String expectedResult2 = "You entered: Welcome";
		if(status2.equals(expectedResult2)) {
			System.out.println("Test Passed");
		}
		else {
		    System.out.println("Test Failed");
		}
		driver.quit();
		
	}
	
}
