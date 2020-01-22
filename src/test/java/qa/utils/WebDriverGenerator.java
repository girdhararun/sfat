package qa.utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverGenerator
{
	private WebDriver driver = null;
	String driverPath = System.getProperty("user.dir")+File.separator+
			"src"+File.separator+"test"+File.separator+"java"+File.separator+"qa"+File.separator+"resources";
	public WebDriver getChromeDriver()
	{
		if(System.getProperty("os.name").contains("Windows"))
			System.setProperty("webdriver.chrome.driver", driverPath+File.separator+"chromedriver.exe");
		else
			System.setProperty("webdriver.chrome.driver", driverPath+File.separator+"chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
