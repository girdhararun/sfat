package qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.keywords.LeadAction;
import qa.utils.TestDataSetup;

public class LeadTest
{	
	private LeadAction lead = new LeadAction();
	TestDataSetup leadtestdata = new TestDataSetup("LeadData.json");
	
	@BeforeClass
	public void tierUp()
	{
		lead.login("akash.verma@qainfotech.com", "akashvermaqa68");
		
	}
	
	
	@Test(priority=1)
	public void verify_home_page()
	{
		Assert.assertEquals(lead.getPageTitle(), "Home | Salesforce",
				"Error in login");
	}
	
	@Test(priority=2)
	public void launch_sales_app()
	{
		lead.app_launch("Sales");
	}
	
	@Test(priority=3)
	public void open_new_lead_form()
	{
		lead.open_new_lead_form();
	}
	
	@Test(priority=4)
	public void fill_lead_form()
	{
		 lead.fill_form_and_save(leadtestdata.getFields());
	}
	
	@Test(priority=5)
	public void verify_form_details()
	{
		lead.open_lead_details();
		Assert.assertEquals(lead.getFormDetail("Email"), leadtestdata.getFieldValue("Email"));
		Assert.assertEquals(lead.getFormDetail("Website"), leadtestdata.getFieldValue("Website"));
		Assert.assertEquals(lead.getFormDetail("SIC Code"), leadtestdata.getFieldValue("SIC Code"));
		Assert.assertEquals(lead.getFormDetail("Name"), 
			leadtestdata.getFieldValue("Salutation") + " " + leadtestdata.getFieldValue("First Name") + " " + leadtestdata.getFieldValue("Last Name"));
		Assert.assertEquals(lead.getFormDetail("Title"), leadtestdata.getFieldValue("Title"));
		
	}
	
	
}
