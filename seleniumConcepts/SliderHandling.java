package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		
		WebElement minSlider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
		System.out.println("Location of Min Slider :" + minSlider.getLocation());
		
		act.dragAndDropBy(minSlider,120,293).perform();
		
		System.out.println("Location of Min Slider :" + minSlider.getLocation());
		
		Thread.sleep(3000);
		
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of Max Slider :" +maxSlider.getLocation());
		
		act.dragAndDropBy(maxSlider,-100,233).perform();
		
		System.out.println("Location of Max Slider :" +maxSlider.getLocation());
		
		driver.quit();

	}

}
