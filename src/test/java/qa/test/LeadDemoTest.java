package qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.utils.TestDataSetup;

import java.text.ParseException;
import java.util.Date;

public class LeadDemoTest extends BaseTestInitiator {
    long time = new Date().getTime();
    TestDataSetup leadtestdata = new TestDataSetup("LeadData.json");

//    @Test
//    public void verifyMeta(){
//        verifyRequiredFields(leadtestdata,"Lead");
//    }

    @Test(priority = 1)
    public void open_new_lead_form() {
        Assert.assertEquals(lead.openObject("Leads"), "Leads");
        Assert.assertEquals(lead.open_new_form(), "New Lead");
    }

    @Test(priority = 2, dependsOnMethods = {"open_new_lead_form"})
    public void fill_new_form() {
        leadtestdata.updateDataValue("Lead Information", "Email", "auto" + time + "@mailinator.in");
        leadtestdata.updateDataValue("Lead Information", "First Name", "auto" + time);

        Assert.assertEquals(lead.fill_form_and_save(leadtestdata), leadtestdata.getFieldValue("Lead Information", "Salutation") + " " +
            leadtestdata.getFieldValue("Lead Information", "First Name") + " " +
            leadtestdata.getFieldValue("Lead Information", "Last Name"));

    }

    @Test(priority = 3, dependsOnMethods = {"fill_new_form"})
    public void verify_form_details() throws ParseException {
        lead.open_form_details();
        Assert.assertEquals(lead.getFormDetail("Name"),
            leadtestdata.getFieldValue("Lead Information", "Salutation") + " " +
                leadtestdata.getFieldValue("Lead Information", "First Name") + " " +
                leadtestdata.getFieldValue("Lead Information", "Last Name"));
        Assert.assertEquals(lead.getFormDetail("Lead Status"), leadtestdata.getFieldValue("Lead Information", "Lead Status"));
    }


}



















