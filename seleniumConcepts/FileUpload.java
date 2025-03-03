package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//single file upload
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\mohan\\Downloads\\text.txt");
		if(driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li")).getText().equals("text.txt")) {
			System.out.println("File is  successfully uploaded");
		}
		else {
			System.out.println("Not upload");
		}
		
		//multiple file upload
		
		String file1 = "C:\\\\Users\\\\mohan\\\\Downloads\\\\text.txt";
		String file2 = "C:\\\\Users\\\\mohan\\\\Downloads\\\\text1.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		
		if(driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li[2]")).getText().equals("text.txt") && driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li[3]")).getText().equals("text1.txt") ) {
			System.out.println("All File is successfully uploaded");
		}
		else {
			System.out.println("Not upload");
		}
		


	}

}
