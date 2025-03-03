package seleniumConcepts;



import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DiferentTypesOfAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@id='alertBtn']"));
		simpleAlert.click();
		Alert simpleAlertHandle = driver.switchTo().alert();
		String status = simpleAlertHandle.getText();
		simpleAlertHandle.accept();
		String expectedResult = "I am an alert box!";
		if(status.equals(expectedResult)){
		System.out.println("Test Passed");
		}
		else{
		System.out.println("Test Failed");
		}
		
		Thread.sleep(3000);
		WebElement confirmationAlert = driver.findElement(By.xpath("//button[@id='confirmBtn']"));
		confirmationAlert.click();
		Alert confirmationAlertHandle = driver.switchTo().alert();
		confirmationAlertHandle.dismiss();
        WebElement status1 = driver.findElement(By.xpath("//p[@id='demo']"));
        String result = status1.getText();
        String expectedResult1 = "You pressed Cancel!";
        if(result.equals(expectedResult1)){
    		System.out.println("Test Passed");
    		}
    		else{
    		System.out.println("Test Failed");
    		}
        Thread.sleep(3000);
        
        WebElement promptAlert = driver.findElement(By.xpath("//button[@id='promptBtn']"));
        promptAlert.click();
        Alert promptAlertClc = driver.switchTo().alert();
        promptAlertClc.sendKeys("Devesh");
        promptAlertClc.accept();
        WebElement status2 = driver.findElement(By.xpath("//p[@id='demo']"));
        String actualResult= status2.getText();
        String expectedResult2 = "Hello Devesh! How are you today?";

        if(actualResult.equals(expectedResult2)){
        System.out.println("Test Passed");
        }
        else{
        System.out.println("Test Failed");
        }

	}

}
