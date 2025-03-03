package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropHandler {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dhtmlgoodies.com/packages/dhtml-suite-for-applications/demos/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//drag and drop = dragAndDrop(sourceElement,targetElement)
		Actions act = new Actions(driver);
		WebElement rome = driver.findElement(By.xpath("//div[text()='Rome']"));
		WebElement italy = driver.findElement(By.xpath("//div[text()='Italy']"));
		act.dragAndDrop(rome, italy).perform();
		Thread.sleep(2000);
		WebElement rome1 = driver.findElement(By.xpath("//div[@id='box106']//div"));
		WebElement capitals = driver.findElement(By.xpath("//div[@id='dropContent']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(rome1,capitals).perform();
		

	}

}
