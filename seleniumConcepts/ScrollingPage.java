package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		scroll down page by pixel number
		
//      js.executeScript("window.scrollBy(0,1200)","");
//      System.out.println(js.executeScript("return window.pageYOffset"));
		
//		scroll the page till the element is visible
//		WebElement locatePageElement = driver.findElement(By.xpath("//strong[text() = 'Community poll']"));
//		js.executeScript("arguments[0].scrollIntoView()",locatePageElement);
//        System.out.println(js.executeScript("return window.pageYOffset"));//2410
        
//		scroll the page till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));
		
		Thread.sleep(5000);
		
//		scroll the page upto initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));

        
	}

}
