package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
	   WebDriver driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
          driver.get("https://testautomationpractice.blogspot.com/");
//          WebElement maleRadiobtn = driver.findElement(By.xpath("//input[@id='male']"));
//          maleRadiobtn.click();
//          WebElement femaleRadiobtn = driver.findElement(By.xpath("//input[@id='female']"));
//          femaleRadiobtn.click();
//          WebElement days = driver.findElement(By.xpath("//input[@id='sunday']"));
//          days.click();
//          JavascriptExecutor js = (JavascriptExecutor)driver;
//          js.executeScript("arguments[0].click()", days);
      
            //Select group of checkboxList
            List<WebElement> listofCheckBoxes=driver.findElements(By.xpath("//input[@class='form-check-input'  and @type=\"checkbox\"]"));
//            for(WebElement checkbox : listofCheckBoxes){
//            	checkbox.click();
//            }
//             for(int i = 0;i<listofCheckBoxes.size();i++) {
//            	 listofCheckBoxes.get(i).click();
//             }
//          Select last 3 checkbox
//            int checkboxCount = listofCheckBoxes.size()-3;
//            for(int i = checkboxCount;i<listofCheckBoxes.size();i++) {
//            	listofCheckBoxes.get(i).click();
//            }
            
//          Select First 3 checkbox
              int checkboxCount = listofCheckBoxes.size()-4;
              for(int i = 0;i<checkboxCount;i++) {
            	 listofCheckBoxes.get(i).click();
               }
              for(int j = 0;j<checkboxCount;j++) {
             	 listofCheckBoxes.get(j).click();
                }
             
            
            Thread.sleep(1000);
            driver.quit();;
	}

}
