package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerHandling {

	public static void selectFutureDate(WebDriver driver,String month,String year,String date) {
		while(true) {
			   String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			   String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			   if(currentMonth.equals(month) && currentYear.equals(year)) {
				   List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td/a"));
				   for(WebElement dt : dates) {
					   if(dt.getText().equals(date)) {
						   dt.click();
						   break;
					   }
				   }
			   }
			   driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
	}
		
		public static void selectPastDate(WebDriver driver,String month,String year,String date) {
			while(true) {
				   String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				   String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
				   if(currentMonth.equals(month) && currentYear.equals(year)) {
					   List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td/a"));
					   for(WebElement dt : dates) {
						   if(dt.getText().equals(date)) {
							   dt.click();
							   break;
						   }
					   }
				   }
				   
				   driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
		}
		
		

	public static void main(String[] args) throws InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://jqueryui.com/datepicker/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	   WebElement demoFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	   driver.switchTo().frame(demoFrame);
	   driver.findElement(By.xpath("//input[@id='datepicker']")).click();
//	   Usind:sendKeys();
//	   driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("20/02/2025");
	   
//	   Using:datepicker
	   
	   String year = "2025";
	   String month = "May";
	   String date = "20";
	   
//	   String year = "2024";
//	   String month = "May";
//	   String date = "20";
//	   
	   DatePickerHandling.selectFutureDate(driver, month, year, date);
//	   DatePickerHandling.selectPastDate(driver, month, year, date);
//	   String monthAndyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//	   System.out.println(monthAndyear);
	   
	   
	   }
}
