package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.switchTo().frame(0);
		WebElement frameTestPage = driver.findElement(By.xpath("//input[@name='mytext1']"));
		frameTestPage.sendKeys("Test Page");
		driver.switchTo().defaultContent();
		
		
	    Thread.sleep(1000);
		WebElement frameElement = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frameElement);
        WebElement locateFrameTwo = driver.findElement(By.xpath("//input[@name='mytext2']"));
        locateFrameTwo.sendKeys("Welcome");
        driver.switchTo().defaultContent();
        
        Thread.sleep(1000);
        
        WebElement frameThreePage = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frameThreePage);
        WebElement locateFrameThree = driver.findElement(By.xpath("//input[@name='mytext3']"));
        locateFrameThree.sendKeys("Welcome");
        driver.switchTo().frame(0);
        WebElement insideFrame = driver.findElement(By.xpath("//div[@id='i9']"));
        insideFrame.click();
        
        WebElement insideCheckBox = driver.findElement(By.xpath("//div[@id='i21']"));
        insideCheckBox.click();
        
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        WebElement locateFourthElement = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
        driver.switchTo().frame(locateFourthElement);
        WebElement locateFourthElementBtn = driver.findElement(By.xpath("//input[@type='text']"));
        locateFourthElementBtn.sendKeys("Welcome");
        driver.switchTo().defaultContent();
        
        Thread.sleep(1000);
        
        WebElement fourthFrame = driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
        driver.switchTo().frame(fourthFrame);
        WebElement fourthFrameLocator = driver.findElement(By.xpath("//input[@name='mytext4']"));
        fourthFrameLocator.clear();
        fourthFrameLocator.sendKeys("Java");
        driver.switchTo().defaultContent();
        
        Thread.sleep(1000);
        
        WebElement fifthFrame = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
        driver.switchTo().frame(fifthFrame);
        
        WebElement fifthFrameLocator = driver.findElement(By.xpath("//input[@name='mytext5']"));
        fifthFrameLocator.sendKeys("Python");
        
        WebElement linkFrame = driver.findElement(By.xpath("//a[text() = 'https://a9t9.com']"));
        linkFrame.click();
	}

}
