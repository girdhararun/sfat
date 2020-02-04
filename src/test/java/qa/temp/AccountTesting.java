package qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qa.resources.Config;

public class AccountTesting extends BaseTestInitiator
{
	@BeforeClass
	public void tierUp()
	{
		login(Config.username, Config.password);
	}
	
	@Test(priority=1)
	public void verify_home_page()
	{
		Assert.assertEquals(getPageTitle(), "Home | Salesforce",
				"Error in login");
	}
	
	@Test(priority=2, dependsOnMethods= {"verify_home_page"})
	public void launch_sales_app()
	{
		Assert.assertEquals(lead.app_launch("Sales"), "Sales");
	}	
	@Test(priority=3, dependsOnMethods={"launch_sales_app"})
	public void open_new_lead_form()
	{
		Assert.assertEquals(lead.open_tab("Accounts"), "Accounts");
		Assert.assertEquals(lead.open_new_form(), "New Account");
	}

}
