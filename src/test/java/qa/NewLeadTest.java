package qa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sforce.ws.ConnectionException;

import sft.GetFields;
import sft.auth.SftSetup;

public class NewLeadTest 
{
	
	static WebDriver driver;
	WebDriverWait wait;
	GetFields leadFields;
	
	
	@BeforeClass
	public void tierUp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"src"+File.separator+"resources"+File.separator+"chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,30000);
		
		
		leadFields = new GetFields("Lead",driver);
	}
	@Test(priority=1)
	public void login()
	{
		driver.navigate().to(SftSetup.getSftSetup().get("domain_url"));
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys("akash.verma@qainfotech.com");
		driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("akashvermaqa68");
		driver.findElement(By.cssSelector("input[id=\"Login\"]")).click();
	}	
	@Test(priority=2)
	public void app_launch()
	{
		click((By.cssSelector("nav button[class *= \"AppLauncher\"]")));
		click(By.xpath("//div[contains(@class,\"dragArea\")]//a[text()=\"Sales\"]"));
		hardwait(5);
	}
	@Test(priority=3)
	public void create_new_lead()
	{	
		click_js("a[title='Leads']");
		click(By.cssSelector("a[title=\"New\"]"));
	}

	@Test(priority=4)
	public void fill_form1() throws ConnectionException
	{	
		leadFields.getObject("Phone").set("7065586031");
		leadFields.getObject("Description").set("My Description");
		leadFields.getObject("Description").clear();
		
		leadFields.getObject("Rating").set("Warm");
		leadFields.getObject("Rating").set("Wa");
	}

	
	@AfterClass
	public void tierDown()
	{
//		driver.close();
//		driver.quit();
	}


	public void click(By locator)
	{
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public void click_js(String locator)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String script = "document.querySelector(\"html\").querySelector(\""+locator+"\").click()";
		executor.executeScript(script);
	}
	
	public void hardwait(int sec)
	{
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeToFile(String s, String filename)
	{
		File file = new File(filename);
		FileWriter filewriter;
		try {
			filewriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(filewriter);
			writer.write(s);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void send_keys(WebElement e, String k)
	{
		if(e != null)
			e.sendKeys(k);
	}

}
