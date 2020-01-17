package qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.keywords.LeadAction;

public class LeadDetailsTest 
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
	public void open_lead()
	{
		lead.open_lead_tab();
		lead.openLead("Akash Verma");
		lead.open_lead_details();
	}
	
	@Test(priority=3)
	public void verify_lead_details()
	{
		lead.detail_test();
	}
	
}





