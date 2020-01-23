package qa.test;

import org.openqa.selenium.WebDriver;

import pojos.leaddata.LeadData;
import qa.keywords.LeadAction;
import qa.resources.Config;
import qa.resources.locators.Locators_Login;
import qa.utils.BaseAction;
import qa.utils.TestDataSetup;
import qa.utils.WebDriverGenerator;
import sft.auth.SftSetup;

public class BaseTestInitiator extends BaseAction
{
	private static WebDriver driver = new  WebDriverGenerator().getChromeDriver();

	//ActionClass
	LeadAction lead;


	//DataClass
	TestDataSetup leadtestdata;
	LeadData leaddata;

	protected BaseTestInitiator()
	{
		super(driver);
		init();
	}

	private void init()
	{
		leaddata = TestDataSetup.getData("LeadData.json",LeadData.class);
		leadtestdata = new TestDataSetup("LeadData.json");
		lead = new LeadAction(driver,leaddata);
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
