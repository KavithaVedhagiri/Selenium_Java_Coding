package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDropDownWithoutSelectClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
		String option = "United Kingdom";
		String[] colorsDrapDown = {"Blue","White","Yellow"};
		driver.findElement(By.xpath("//select[@id='country']")).click();
		List<WebElement> countryDrapDowns = driver.findElements(By.cssSelector("option"));
		System.out.println(countryDrapDowns.size());
		for(WebElement countryDrapDown : countryDrapDowns){
			System.out.println(countryDrapDown.getText());
			if(countryDrapDown.getText().contains(option))
				countryDrapDown.click();
		}
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//select[@id='colors']")).click();
		List<WebElement> colorsDrapDown1 = driver.findElements(By.xpath("//select[@id='colors']//option"));
		for(WebElement colorDrapDown1 : colorsDrapDown1) {
			for(String colorDrapDown : colorsDrapDown) {
			   if(colorDrapDown1.getText().contains(colorDrapDown)) {
				   colorDrapDown1.click();
			}
		}
		}
		
		String[] animals = {"Cat","Dog","Fox"};
		
		driver.findElement(By.xpath("//select[@id='animals']")).click();
		List<WebElement> animalDrapDown = driver.findElements(By.xpath("//select[@id='animals']//option"));
		
		for(int i=0;i<animalDrapDown.size();i++) {
			for(int j = 0;j<animals.length;j++) {
				String animal = animals[j].toString();
				if(animalDrapDown.get(i).getText().contains(animal)) {
				 	animalDrapDown.get(i).click();
				}
			}
				
		}
	}

}
