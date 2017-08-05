import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bridgeline1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("src/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver","C:/Users/Chait/Downloads/chromedriver_win32/chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
		driver.get("http://google.com");
		
		driver.findElement(By.id("gb_70")).click();
		driver.findElement(By.cssSelector("#identifierId")).sendKeys(prop.getProperty("userName"));
		driver.findElement(By.cssSelector("#identifierNext > content > span")).click();
		WebDriverWait wd=new WebDriverWait(driver,5);
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")));
		driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector("#passwordNext > content > span")).click();
		
	    driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("diamond jig"+"\n");
	   // System.out.println("check");
		
		driver.findElement(By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a")).click();
	    Thread.sleep(3000L);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[3]/div[1]/div[2]/h3/a")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath("//div[contains(text(),'Save to Shortlist')]")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(".//div[@role='alertdialog']/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]")).click();
		Thread.sleep(3000L);
		driver.findElement(By.xpath(".//textarea[@placeholder = 'Add note']")).sendKeys("Please buy me");
	    driver.findElement(By.xpath(".//div[@role='alertdialog']/div[1]/div[2]/div[3]/div/div[2]/div[1]")).click();
	    
	    driver.quit();

	}

}
