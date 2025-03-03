package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertWithOutSwitch {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@id='alertBtn']"));
		simpleAlert.click();
		Alert simpleAlertClick = myWait.until(ExpectedConditions.alertIsPresent());
		String status = simpleAlertClick.getText();
		simpleAlertClick.accept();
		String expectedResult = "I am an alert box!";
		if (status.equals(expectedResult)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		Thread.sleep(3000);

		WebElement confirmationAlert = driver.findElement(By.xpath("//button[@id='confirmBtn']"));
		confirmationAlert.click();
//		WebDriverWait myWait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		Alert confirmationAlertclc = myWait.until(ExpectedConditions.alertIsPresent());
		confirmationAlertclc.dismiss();
		WebElement status1 = driver.findElement(By.xpath("//p[@id='demo']"));
		String actualResult1 = status1.getText();
		String expectedResult1 = "You pressed Cancel!";
		if (actualResult1.equals(expectedResult1)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		Thread.sleep(3000);

		WebElement promptAlert = driver.findElement(By.xpath("//button[@id='promptBtn']"));
		promptAlert.click();
//		WebDriverWait myWait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		Alert promptAlertClc = myWait.until(ExpectedConditions.alertIsPresent());
		promptAlertClc.sendKeys("Devesh");
		promptAlertClc.accept();
		WebElement status2 = driver.findElement(By.xpath("//p[@id='demo']"));
		String actualResult = status2.getText();
		String expectedResult2 = "Hello Devesh! How are you today?";

		if (actualResult.equals(expectedResult2)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

	}

}
