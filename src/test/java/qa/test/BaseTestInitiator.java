package qa.test;

import org.openqa.selenium.WebDriver;
import qa.keywords.AccountAction;
import qa.keywords.LeadAction;
import qa.resources.Config;
import qa.utils.TestDataSetup;
import qa.utils.WebDriverGenerator;
import sft.locators.Locators_Login;
import sft.utils.BaseActions;

public class BaseTestInitiator extends BaseActions
{
	private static WebDriver driver = new  WebDriverGenerator().getChromeDriver();

	//ActionClass
	LeadAction lead;
	AccountAction account;

	//DataClass
	TestDataSetup leadtestdata;

	protected BaseTestInitiator()
	{
		super(driver);
		init();
	}

	private void init()
	{
		leadtestdata = new TestDataSetup("LeadData.json");
		lead = new LeadAction(driver,leadtestdata);
		account = new AccountAction(driver);
	}

	public void login(String username, String password)
	{
		launchUrl(Config.domain);
		webelement(Locators_Login.input_username).sendKeys(username);
		webelement(Locators_Login.input_password).sendKeys(password);
		click(Locators_Login.btn_login);
		hardwait(15);
	}
}
