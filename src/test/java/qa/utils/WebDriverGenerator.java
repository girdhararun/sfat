package qa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sft.utils.ConfigReader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public WebDriver remoteChromeDriver(){
        DesiredCapabilities cap = null;
        cap = DesiredCapabilities.chrome();
        String seleniuhubaddress = driverConfig.getSetupDetails().get("remoteAddress");
        URL selserverhost = null;
        try {
            selserverhost = new URL(seleniuhubaddress);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(selserverhost,cap);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
