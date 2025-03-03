package seleniumConcepts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInAndZoomOut {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
//		Thread.sleep(5000);
//		driver.manage().window().minimize();
//		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(5000);
		js.executeScript("document.body.style.zoom = '50%'");
		
		Thread.sleep(5000);
		js.executeScript("document.body.style.zoom = '80%'");

		
		
	}

}
