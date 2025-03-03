package seleniumConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement textArea1 = driver.findElement(By.id("inputText1"));
//		WebElement textArea2 = driver.findElement(By.id("inputText2"));
		textArea1.sendKeys("Welcome");
		
		Actions act = new Actions(driver);
		
		//keyDown() = Lock the data
		//keyUp() =  release the data
		
		//ctrl+shift+A
		// act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUP(SHIFT).keyUP(CONTROL).perform();
		
		//Enter
		//act.keyDown(Keys.ENTER).keyUP(Keys.ENTER).perform();
		
		//ctrl+A select a text
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//ctrl+c copy the text
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//TAB = shift to textArea 2
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//ctrl+v paste the value
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		
		
	}

}
