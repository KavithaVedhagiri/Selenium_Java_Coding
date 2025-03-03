package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

	public static void main(String[] args) {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.get("https://demo.opencart.com/");
//	  driver.switchTo().newWindow(WindowType.TAB);
	  driver.switchTo().newWindow(WindowType.WINDOW);
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  System.out.println(driver.getCurrentUrl());

	}

}
