import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class synchronizationAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Darmolyn\\Desktop\\Projects\\Drivers\\ChromeDriver\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://rahulshettyacademy.com/loginpagePractise/");
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); // implicit wait
				
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
				driver.findElement(By.xpath("//label[2]/span[2]")).click();
				
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000)); 	//explicit wait

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))); 	//using explicit wait

				driver.findElement(By.id("okayBtn")).click();
				Thread.sleep(1000);

				WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
				Thread.sleep(1000);

				Select dropdown = new Select(options);
				Thread.sleep(1000);

				dropdown.selectByValue("consult");
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//input[@id='terms']")).click(); //clicking checkbox
				Thread.sleep(1000);

				driver.findElement(By.id("signInBtn")).click();
				Thread.sleep(1000);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout"))); //cos the text was actually " Checkout(0) "
				Thread.sleep(1000);

				List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
				Thread.sleep(1000);

				for(int i =0; i<products.size(); i++) {
				products.get(i).click();
				}
				Thread.sleep(1000);

				driver.findElement(By.partialLinkText("Checkout")).click(); //because the text was actually " Checkout "
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
				driver.findElement(By.partialLinkText("Checkout")).click();
				// //app-card[1]//div[1]//div[2]//button[1]    //app-card[1]//div[1]//div[2]//button[1] //app-card[1]//div[1]//div[2]//button[1]
				
			}
	}

