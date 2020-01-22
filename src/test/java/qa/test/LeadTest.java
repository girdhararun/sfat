package qa.test;

import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pojos.leaddata.LeadData;
import qa.keywords.LeadAction;
import qa.utils.TestDataSetup;
import sft.auth.SftSetup;

public class LeadTest
{	
	private LeadAction lead;
	private TestDataSetup leadtestdata;
	private LeadData leaddata;
	@BeforeClass
	public void tierUp()
	{
		leaddata = TestDataSetup.getData("LeadData.json",LeadData.class);
		leadtestdata = new TestDataSetup("LeadData.json");
		lead = new LeadAction();
		lead.login(SftSetup.getSftSetup().get("username"), SftSetup.getSftSetup().get("login_password"));
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
		Assert.assertEquals(lead.app_launch("Sales"), "Sales");
	}	
	@Test(priority=3)
	public void open_new_lead_form()
	{
		Assert.assertEquals(lead.open_tab("Leads"), "Leads");
		Assert.assertEquals(lead.open_new_form(), "New Lead");
	}
	@Test(priority=4)
	public void fill_new_form()
	{
		 Assert.assertEquals(lead.fill_form_and_save(leadtestdata.getFields()),
				leaddata.getLeadInformation().getSalutation().getValue() + " " +
				leaddata.getLeadInformation().getFirstName().getValue() + " " + 
				leaddata.getLeadInformation().getLastName().getValue());
	}
	
	@Test(priority=5)
	public void verify_form_details() throws ParseException
	{
		lead.open_form_details();
		
		//Using testdata from json directly
		Assert.assertEquals(lead.getFormDetail("Name"), 
			leadtestdata.getFieldValue("Lead Information","Salutation") + " " +
			leadtestdata.getFieldValue("Lead Information","First Name") + " " + 
			leadtestdata.getFieldValue("Lead Information","Last Name"));
		Assert.assertEquals(lead.getFormDetail("Mobile"), leadtestdata.getFieldValue("Lead Information","Mobile"));
		Assert.assertEquals(lead.getFormDetail("Company"), leadtestdata.getFieldValue("Lead Information","Company"));
		Assert.assertEquals(lead.getFormDetail("Fax"), leadtestdata.getFieldValue("Lead Information","Fax"));
		Assert.assertEquals(lead.getFormDetail("Title"), leadtestdata.getFieldValue("Lead Information","Title"));
		Assert.assertEquals(lead.getFormDetail("Email"), leadtestdata.getFieldValue("Lead Information","Email"));
		Assert.assertEquals(lead.getFormDetail("Lead Source"), leadtestdata.getFieldValue("Lead Information","Lead Source"));
		Assert.assertEquals(lead.getFormDetail("Website"), leadtestdata.getFieldValue("Lead Information","Website"));
		Assert.assertEquals(lead.getFormDetail("Industry"), leadtestdata.getFieldValue("Lead Information","Industry"));
		Assert.assertEquals(lead.getFormDetail("Lead Status"), leadtestdata.getFieldValue("Lead Information","Lead Status"));
		Assert.assertEquals(lead.getFormDetail("Annual Revenue"), "$3,000,000,000");
		Assert.assertEquals(lead.getFormDetail("Rating"), leadtestdata.getFieldValue("Lead Information","Rating"));
		Assert.assertEquals(lead.getFormDetail("Address"),
						leadtestdata.getFieldValue("Address Information","Street")+"\n"+
						leadtestdata.getFieldValue("Address Information","City")+", "+
						leadtestdata.getFieldValue("Address Information","State/Province")+" "+
						leadtestdata.getFieldValue("Address Information","Zip/Postal Code")+"\n"+
						leadtestdata.getFieldValue("Address Information","Country"));
		Assert.assertEquals(lead.getFormDetail("Product Interest"), leadtestdata.getFieldValue("Additional Information","Product Interest"));
		Assert.assertEquals(lead.getFormDetail("Current Generator(s)"), leadtestdata.getFieldValue("Additional Information","Current Generator(s)"));
		Assert.assertEquals(lead.getFormDetail("SIC Code"), leadtestdata.getFieldValue("Additional Information","SIC Code"));
		Assert.assertEquals(lead.getFormDetail("Primary"), leadtestdata.getFieldValue("Additional Information","Primary"));
		
		
		//Using testdata pojo
		Assert.assertEquals(lead.getFormDetail("Name"), 
			leaddata.getLeadInformation().getSalutation().getValue() + " " +
			leaddata.getLeadInformation().getFirstName().getValue() + " " + 
			leaddata.getLeadInformation().getLastName().getValue());
		Assert.assertEquals(lead.getFormDetail("Mobile"), leaddata.getLeadInformation().getMobile().getValue());
		Assert.assertEquals(lead.getFormDetail("Company"), leaddata.getLeadInformation().getCompany().getValue());
		Assert.assertEquals(lead.getFormDetail("Fax"), leaddata.getLeadInformation().getFax().getValue());
		Assert.assertEquals(lead.getFormDetail("Title"), leaddata.getLeadInformation().getTitle().getValue());
		Assert.assertEquals(lead.getFormDetail("Email"),  leaddata.getLeadInformation().getEmail().getValue());
		
		//Update file LeadData.json
		leadtestdata.updateFieldValue("Additional Information","SIC Code","987654");
	}
}
