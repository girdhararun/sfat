package qa.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.keywords.LeadAction;

public class LeadTest
{	
	private LeadAction lead = new LeadAction();
	
	@BeforeClass
	public void tierUp()
	{
		lead.login("akash.verma@qainfotech.com", "akashvermaqa68");
	}
	
	@Test(priority=1)
	public void launch_sales_app()
	{
		lead.app_launch("Sales");
	}
	
	@Test(priority=2)
	public void open_lead_form()
	{
		lead.open_lead_form();
	}
	
	@Test(priority=3)
	public void fill_lead_form()
	{
		lead.fill_form();
	}
}
