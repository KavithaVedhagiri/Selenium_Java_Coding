package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/frame.xhtml");
		WebElement clickMeFrame = driver.findElement(By.xpath("//iframe[@src='default.xhtml']"));
		driver.switchTo().frame(clickMeFrame);
        WebElement clickMeButton =  driver.findElement(By.xpath("//button[text() = 'Click Me']"));
        clickMeButton.click();
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
      
        WebElement parentFrame = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
        List<WebElement> iframeCount = driver.findElements(By.tagName("iframe"));
        System.out.println(iframeCount.size());
        driver.switchTo().frame(parentFrame);
        WebElement childFrame = driver.findElement(By.xpath("//iframe[@src='framebutton.xhtml']"));
        driver.switchTo().frame(childFrame);
        WebElement insideFrameClickMeBtn = driver.findElement(By.xpath("//button[@id='Click']"));
        insideFrameClickMeBtn.click();
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        
        List<WebElement> iframeCount1 = driver.findElements(By.tagName("iframe"));
          System.out.println(iframeCount1.size());
		}

}
