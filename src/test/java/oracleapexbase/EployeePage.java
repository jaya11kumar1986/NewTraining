package oracleapexbase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EployeePage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://localhost:8888/ords/r/htss_ws1/employee/login");
		
		driver.findElement(By.id("P9999_USERNAME")).sendKeys("admin");
		driver.findElement(By.id("P9999_PASSWORD")).sendKeys("Htss123");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement navButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='t_Button_navControl']")));
		navButton.click();
		driver.findElement(By.xpath("//*[text()='Employee_Info']")).click();
		driver.findElement(By.xpath("//*[text()='Create']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("P7_NAME")).sendKeys("Tamil");
		
		WebElement dropdown = driver.findElement(By.id("P7_MARITAL_STATUS"));
		Select sel=new Select(dropdown);
		List<WebElement> options = sel.getOptions();
		int total = options.size();
		int seconlast=total-2;
		
		for(WebElement opt:options) {
			
			System.out.println(opt.getText());
		}
		
		if(total>=2) {
			sel.selectByIndex(seconlast);
		}
		driver.findElement(By.xpath("//*[text()='Create']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[text()='ADMIN']")).click();
		

	}
	
	

}
