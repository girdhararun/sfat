package qa.test;

import com.sforce.soap.enterprise.sobject.Lead;
import com.sforce.soap.enterprise.sobject.Report;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qa.utils.TestDataSetup;

import java.text.ParseException;
import java.util.Date;

public class LeadDemoTest extends BaseTestInitiator {
    long time = new Date().getTime();
    TestDataSetup leadtestdata = new TestDataSetup("LeadData.json");

    @BeforeClass
    public void tierUp() {
        login(autoConfig.get("username"), autoConfig.get("password"));
        lead.openApp("Sales");
        lead.openObject("Leads");
        lead.open_new_form();
    }

    @Test(priority = 1)
    public void Step01_verifyMeta() {
        verifyRequiredFields(leadtestdata, "Lead");
    }


    @Test(priority = 2, dependsOnMethods = {"Step01_verifyMeta"})
    public void Step02_fillNewForm() {
        leadtestdata.updateDataValue("Lead Information", "Email", "auto" + time + "@mailinator.in");
        leadtestdata.updateDataValue("Lead Information", "First Name", "auto" + time);
        Assert.assertEquals(lead.fill_form_and_save(leadtestdata), leadtestdata.getFieldValue("Lead Information", "Salutation") + " " +
            leadtestdata.getFieldValue("Lead Information", "First Name") + " " +
            leadtestdata.getFieldValue("Lead Information", "Last Name"));
    }

    @Test(priority = 3, dependsOnMethods = {"Step02_fillNewForm"})
    public void Step03_verifyFormDetails() throws ParseException {
        SoftAssert sa = new SoftAssert();
        System.out.println(leadtestdata.getField("['Lead Information']['Phone']['value']"));
        lead.open_form_details();
        //Using testdata from json directly
        Assert.assertEquals(lead.getFormDetail("Name"),
            leadtestdata.getFieldValue("Lead Information", "Salutation") + " " +
                leadtestdata.getFieldValue("Lead Information", "First Name") + " " +
                leadtestdata.getFieldValue("Lead Information", "Last Name"));
        sa.assertEquals(lead.getFormDetail("Mobile"), leadtestdata.getFieldValue("Lead Information", "Mobile"));
        sa.assertEquals(lead.getFormDetail("Company"), leadtestdata.getFieldValue("Lead Information", "Company"));
        sa.assertEquals(lead.getFormDetail("Fax"), leadtestdata.getFieldValue("Lead Information", "Fax"));
        sa.assertEquals(lead.getFormDetail("Title"), leadtestdata.getFieldValue("Lead Information", "Title"));
        sa.assertEquals(lead.getFormDetail("Rating"), leadtestdata.getFieldValue("Lead Information", "Rating"));
        sa.assertEquals(lead.getFormDetail("Product Interest"), leadtestdata.getFieldValue("Additional Information", "Product Interest"));
        sa.assertEquals(lead.getFormDetail("Current Generator(s)"), leadtestdata.getFieldValue("Additional Information", "Current Generator(s)"));
        sa.assertEquals(lead.getFormDetail("SIC Code"), leadtestdata.getFieldValue("Additional Information", "SIC Code"));
        sa.assertEquals(lead.getFormDetail("Primary"), leadtestdata.getFieldValue("Additional Information", "Primary"));
        sa.assertAll();
        Reporter.log("Verified form details for :"+lead.getFormDetail("Name"));
    }

    @Test(priority = 4, dependsOnMethods = {"Step03_verifyFormDetails"})
    public void Step04_updateFormDetails() {
        lead.oneAction("Edit");
        lead.updateFormDetail(leadtestdata, "Lead Information", "Fax", "654321");
        lead.updateFormDetail(leadtestdata, "Lead Information", "Lead Status", "Closed - Converted");
        lead.saveForm();
        Assert.assertEquals(lead.getFormDetail("Fax"), leadtestdata.getFieldValue("Lead Information", "Fax"));
        Assert.assertEquals(lead.getFormDetail("Lead Status"), leadtestdata.getFieldValue("Lead Information", "Lead Status"));
    }

    @Test(priority = 5, dependsOnMethods = {"Step04_updateFormDetails"})
    public void Step05_verifyDbDetails() {
        Lead dbLead = lead.get_Lead_details_db(leadtestdata.getFieldValue("Lead Information", "Email"));
        Assert.assertEquals(dbLead.getFirstName(), leadtestdata.getFieldValue("Lead Information", "First Name"));
        Assert.assertEquals(dbLead.getLastName(), leadtestdata.getFieldValue("Lead Information", "Last Name"));
        Assert.assertEquals(dbLead.getStatus(), leadtestdata.getFieldValue("Lead Information", "Lead Status"));
        Reporter.log("Verified database details for Lead : "+dbLead.getFirstName());
    }

}



















