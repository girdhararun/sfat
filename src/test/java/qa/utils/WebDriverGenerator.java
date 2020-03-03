package qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sft.utils.ConfigReader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class WebDriverGenerator
{
	private WebDriver driver = null;
    public static ConfigReader driverConfig = new ConfigReader(System.getProperty("user.dir") + File.separator + "autoSetup.json");
	private int implicitWait = Integer.parseInt(driverConfig.getSetupDetails().get("implicitWait"));
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
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
