package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorFrameHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://ui.vision/demo/webtest/frames/");
		WebElement frameTestPage = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frameTestPage);
		WebElement frameLocatorfirst = driver.findElement(By.xpath("//input[@name='mytext1']"));
		frameLocatorfirst.sendKeys("Test Page");
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		WebElement frameThreePage = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frameThreePage);
		WebElement locateFrameThree = driver.findElement(By.xpath("//input[@name='mytext3']"));
		locateFrameThree.sendKeys("Welcome");
		driver.switchTo().frame(0);
		WebElement insideFrame = driver.findElement(By.xpath("//div[@id='i9']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", insideFrame);
	}

}
