package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTableHandling2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.blazedemo.com/");
		WebElement departureCity  = driver.findElement(By.xpath("//select[@name='fromPort']"));		
		Select sc= new Select(departureCity);
		sc.selectByVisibleText("Philadelphia");
		
		WebElement destinationCity =  driver.findElement(By.xpath("//select[@name='toPort']"));
		destinationCity.sendKeys("New York");
		
		WebElement findFlight = driver.findElement(By.xpath("//input[@type='submit']"));
		findFlight.click();
		
		double min = Integer.MAX_VALUE;
		double originalValue = 0;
	    double option = 200.98;
		
		
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@class='table']//tr"));
        
		for (int row = 1;row<=totalRows.size(); row++) {
			String price = driver.findElement(By.xpath("//table[@class='table']//tr["+row+"]//td[6]")).getText();
			price=price.replace("$", "").replace(",", "");
			originalValue= Double.parseDouble(price);
			
			if(min>originalValue) {
				min = originalValue;
			}
			if(min == option ) {

				driver.findElement(By.xpath("//table[@class='table']//tr["+row+"]//td[1]")).click();
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				String text = driver.findElement(By.xpath("//h1")).getText();
				if(text.equals("Thank you for your purchase today!")) {
					System.out.println("Test passed");
				}
			}
			
		}
		driver.close();
	
		 
		
	}

}
