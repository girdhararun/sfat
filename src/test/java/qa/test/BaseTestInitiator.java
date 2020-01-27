package qa.test;

import org.openqa.selenium.WebDriver;
import pojos.leaddata.LeadData;
import qa.keywords.LeadAction;
import qa.resources.Config;
import qa.resources.locators.Locators_Login;
import qa.utils.BaseAction;
import qa.utils.TestDataSetup;
import qa.utils.WebDriverGenerator;

import java.util.Date;

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
		long time= new Date().getTime();
		leadtestdata = new TestDataSetup("LeadData.json");
		leadtestdata.updateFieldValue("Lead Information", "Email", "auto"+time+"@mailinator.in");
		leadtestdata.updateFieldValue("Lead Information","First Name", "auto"+time);
		leaddata = TestDataSetup.getData("LeadData.json",LeadData.class);
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
