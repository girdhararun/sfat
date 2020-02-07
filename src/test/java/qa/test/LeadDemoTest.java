package qa.test;

import com.sforce.soap.enterprise.sobject.Lead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.resources.Config;

import java.text.ParseException;

public class LeadDemoTest extends BaseTestInitiator
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
		Assert.assertEquals(lead.open_tab("Leads"), "Leads");
		Assert.assertEquals(lead.open_new_form(), "New Lead");
	}
	@Test(priority=4,dependsOnMethods={"open_new_lead_form"})
	public void fill_new_form()
	{
		 Assert.assertEquals(lead.fill_form_and_save(leadtestdata),leadtestdata.getFieldValue("Lead Information","Salutation") + " " +
					leadtestdata.getFieldValue("Lead Information","First Name") + " " +
					leadtestdata.getFieldValue("Lead Information","Last Name"));
		 lead.click_form_details_action_toggle_and_click("Edit");
		 
		 
		System.out.println(">>>>>>>>>>>>>>>>>" + lead.getLeadFields().getObject("Street").edit_get());
		System.out.println(">>>>>>>>>>>>>>>>>" + lead.getLeadFields().getObject("Salutation").edit_get());
		System.out.println(">>>>>>>>>>>>>>>>>" +lead.getLeadFields().getObject("Phone").edit_get());
		 
		lead.saveForm();
	}

	//@Test(priority=5,dependsOnMethods= {"fill_new_form"})
	public void verify_form_details() throws ParseException
	{
		
		
		System.out.println(leadtestdata.getFieldset("Lead Information"));
		System.out.println(leadtestdata.getField("['Lead Information']['Phone']['value']"));
		
		lead.open_form_details();

		//Using testdata from json directly
		Assert.assertEquals(lead.getFormDetail("Name"),
			leadtestdata.getFieldValue("Lead Information","Salutation") + " " +
			leadtestdata.getFieldValue("Lead Information","First Name") + " " +
			leadtestdata.getFieldValue("Lead Information","Last Name"));
		Assert.assertEquals(lead.getFormDetail("Mobile"), leadtestdata.getFieldValue("Lead Information","Mobile"));
		Assert.assertEquals(lead.getFormDetail("Company"), leadtestdata.getFieldValue("Lead Information","Company"));
		Assert.assertEquals(lead.getFormDetail("Fax"), leadtestdata.getFieldValue("Lead Information","Fax"));
//		Assert.assertEquals(lead.getFormDetail("Title"), leadtestdata.getFieldValue("Lead Information","Title"));
		Assert.assertEquals(lead.getFormDetail("Rating"), leadtestdata.getFieldValue("Lead Information","Rating"));
		Assert.assertEquals(lead.getFormDetail("Product Interest"), leadtestdata.getFieldValue("Additional Information","Product Interest"));
		Assert.assertEquals(lead.getFormDetail("Current Generator(s)"), leadtestdata.getFieldValue("Additional Information","Current Generator(s)"));
		Assert.assertEquals(lead.getFormDetail("SIC Code"), leadtestdata.getFieldValue("Additional Information","SIC Code"));
		Assert.assertEquals(lead.getFormDetail("Primary"), leadtestdata.getFieldValue("Additional Information","Primary"));

		//Update file LeadData.json
		leadtestdata.updateFieldValue("Additional Information","SIC Code","987654");
	}
	
	//@Test(priority=6,dependsOnMethods= {"verify_form_details"})
	public void update_form_details()
	{
		lead.click_form_details_action_toggle_and_click("Edit");
		lead.update_form_details();
		Assert.assertEquals(lead.getFormDetail("Fax"), leadtestdata.getFieldValue("Lead Information","Fax"));
		Assert.assertEquals(lead.getFormDetail("Lead Status"), leadtestdata.getFieldValue("Lead Information","Lead Status"));
	}

	//@Test(priority=7)
	public void verify_details_from_db()
	{
		Lead dblead = lead.verify_details_from_db();
		Assert.assertEquals(dblead.getFirstName(), leadtestdata.getFieldValue("Lead Information","First Name"));
		Assert.assertEquals(dblead.getLastName(), leadtestdata.getFieldValue("Lead Information","Last Name"));
		Assert.assertEquals(dblead.getStatus(), leadtestdata.getFieldValue("Lead Information","Lead Status"));
	}

}



















