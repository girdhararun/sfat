package qa.test;

import com.sforce.soap.enterprise.sobject.Lead;
import org.testng.Assert;
import org.testng.annotations.Test;
import qa.utils.TestDataSetup;

import java.text.ParseException;
import java.util.Date;

public class LeadDemoTest extends BaseTestInitiator {
    long time = new Date().getTime();
    TestDataSetup leadtestdata = new TestDataSetup("LeadData.json");

    @Test
    public void Step01_verifyMeta() {
        verifyRequiredFields(leadtestdata, "Lead");
    }

    @Test(priority = 1)
    public void Step02_verify_home_page() {
        Assert.assertEquals(lead.openApp("Sales"), "Home | Salesforce",
            "Error in login");
    }

    @Test(priority = 3, dependsOnMethods = {"Step02_verify_home_page"})
    public void Step03_open_new_lead_form() {
        Assert.assertEquals(lead.openObject("Leads"), "Leads");
        Assert.assertEquals(lead.open_new_form(), "New Lead");
    }

    @Test(priority = 4, dependsOnMethods = {"Step03_open_new_lead_form"})
    public void Step04_fill_new_form() {
        leadtestdata.updateDataValue("Lead Information", "Email", "auto" + time + "@mailinator.in");
        leadtestdata.updateDataValue("Lead Information", "First Name", "auto" + time);
        Assert.assertEquals(lead.fill_form_and_save(leadtestdata), leadtestdata.getFieldValue("Lead Information", "Salutation") + " " +
            leadtestdata.getFieldValue("Lead Information", "First Name") + " " +
            leadtestdata.getFieldValue("Lead Information", "Last Name"));
//		 lead.click_form_details_action_toggle_and_click("Edit");
        lead.oneAction("Edit");

        // Reading from edit form
        System.out.println(">>>>>>>>>>>>>>>>>" + lead.getLeadFields().getObject("Street").edit_get());
        System.out.println(">>>>>>>>>>>>>>>>>" + lead.getLeadFields().getObject("Salutation").edit_get());
        System.out.println(">>>>>>>>>>>>>>>>>" + lead.getLeadFields().getObject("Phone").edit_get());

        lead.saveForm();
    }

    @Test(priority = 5, dependsOnMethods = {"Step04_fill_new_form"})
    public void Step05_verify_form_details() throws ParseException {
        System.out.println(leadtestdata.getField("['Lead Information']['Phone']['value']"));
        lead.open_form_details();
        //Using testdata from json directly
        Assert.assertEquals(lead.getFormDetail("Name"),
            leadtestdata.getFieldValue("Lead Information", "Salutation") + " " +
                leadtestdata.getFieldValue("Lead Information", "First Name") + " " +
                leadtestdata.getFieldValue("Lead Information", "Last Name"));
        Assert.assertEquals(lead.getFormDetail("Mobile"), leadtestdata.getFieldValue("Lead Information", "Mobile"));
        Assert.assertEquals(lead.getFormDetail("Company"), leadtestdata.getFieldValue("Lead Information", "Company"));
        Assert.assertEquals(lead.getFormDetail("Fax"), leadtestdata.getFieldValue("Lead Information", "Fax"));
        Assert.assertEquals(lead.getFormDetail("Title"), leadtestdata.getFieldValue("Lead Information", "Title"));
        Assert.assertEquals(lead.getFormDetail("Rating"), leadtestdata.getFieldValue("Lead Information", "Rating"));
        Assert.assertEquals(lead.getFormDetail("Product Interest"), leadtestdata.getFieldValue("Additional Information", "Product Interest"));
        Assert.assertEquals(lead.getFormDetail("Current Generator(s)"), leadtestdata.getFieldValue("Additional Information", "Current Generator(s)"));
        Assert.assertEquals(lead.getFormDetail("SIC Code"), leadtestdata.getFieldValue("Additional Information", "SIC Code"));
        Assert.assertEquals(lead.getFormDetail("Primary"), leadtestdata.getFieldValue("Additional Information", "Primary"));

        leadtestdata.updateDataValue("Additional Information", "SIC Code", "987654");
    }

    @Test(priority = 6, dependsOnMethods = {"Step05_verify_form_details"})
    public void Step06_update_form_details() {
//        leadtestdata.updateDataValue("Lead Information","Fax","654321");
//        leadtestdata.updateDataValue("Lead Information","Lead Status","Closed - Converted");
        lead.oneAction("Edit");
        lead.updateFormDetail(leadtestdata, "Lead Information", "Fax", "654321");
        lead.updateFormDetail(leadtestdata, "Lead Information", "Lead Status", "Closed - Converted");
        lead.saveForm();
        Assert.assertEquals(lead.getFormDetail("Fax"), leadtestdata.getFieldValue("Lead Information", "Fax"));
        Assert.assertEquals(lead.getFormDetail("Lead Status"), leadtestdata.getFieldValue("Lead Information", "Lead Status"));
    }

    @Test(priority = 7)
    public void Step_07verify_details_from_db() {
        Lead dbLead = lead.get_Lead_details_db(leadtestdata.getFieldValue("Lead Information", "Email"));
        Assert.assertEquals(dbLead.getFirstName(), leadtestdata.getFieldValue("Lead Information", "First Name"));
        Assert.assertEquals(dbLead.getLastName(), leadtestdata.getFieldValue("Lead Information", "Last Name"));
        Assert.assertEquals(dbLead.getStatus(), leadtestdata.getFieldValue("Lead Information", "Lead Status"));
    }

}



















