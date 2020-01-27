package qa.test;

import java.util.Date;
import org.openqa.selenium.WebDriver;
import pojos.leaddata.LeadData;
import qa.keywords.AccountAction;
import qa.keywords.LeadAction;
import qa.resources.Config;
import qa.resources.locators.Locators_Login;
import qa.utils.TestDataSetup;
import qa.utils.WebDriverGenerator;
import sft.utils.BaseActions;

public class BaseTestInitiator extends BaseActions
{
	private static WebDriver driver = new  WebDriverGenerator().getChromeDriver();

	//ActionClass
	LeadAction lead;
	AccountAction account;

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
		long time= new Date().getTime();
		leadtestdata = new TestDataSetup("LeadData.json");
		leadtestdata.updateFieldValue("Lead Information", "Email", "t.tester"+time+"@yahoo.in");
		leadtestdata.updateFieldValue("Lead Information","First Name", "Akash"+time);
		leaddata = TestDataSetup.getData("LeadData.json",LeadData.class);
		lead = new LeadAction(driver,leaddata);
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
