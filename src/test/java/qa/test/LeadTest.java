package qa.test;

import com.sforce.soap.enterprise.sobject.Lead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.resources.Config;

import java.text.ParseException;

public class LeadTest extends BaseTestInitiator {

    @BeforeClass
    public void tierUp() {
        login(Config.username, Config.password);
    }

    @Test(priority = 1)
    public void verify_home_page() {
        Assert.assertEquals(getPageTitle(), "Home | Salesforce",
            "Error in login");
    }

    @Test(priority = 2, dependsOnMethods = {"verify_home_page"})
    public void launch_sales_app() {
        Assert.assertEquals(lead.app_launch("Sales"), "Sales");
    }

    @Test(priority = 3, dependsOnMethods = {"launch_sales_app"})
    public void open_new_lead_form() {
        Assert.assertEquals(lead.open_tab("Leads"), "Leads");
        Assert.assertEquals(lead.open_new_form(), "New Lead");
    }

    @Test(priority = 4, dependsOnMethods = {"open_new_lead_form"})
    public void fill_new_form() {
        Assert.assertEquals(lead.fill_form_and_save(leadtestdata),
            leaddata.getLeadInformation().getSalutation().getValue() + " " +
                leaddata.getLeadInformation().getFirstName().getValue() + " " +
                leaddata.getLeadInformation().getLastName().getValue());
    }

    @Test(priority = 5, dependsOnMethods = {"fill_new_form"})
    public void verify_form_details() throws ParseException {
        lead.open_form_details();

        //Using testdata pojo

        Assert.assertEquals(lead.getFormDetail("Name"),
            leaddata.getLeadInformation().getSalutation().getValue() + " " +
                leaddata.getLeadInformation().getFirstName().getValue() + " " +
                leaddata.getLeadInformation().getLastName().getValue());
//		Assert.assertEquals(lead.getFormDetail("Title"), leaddata.getLeadInformation().getTitle().getValue());
        Assert.assertEquals(lead.getFormDetail(leaddata.getLeadInformation().getEmail().getLabel()), leaddata.getLeadInformation().getEmail().getValue());

        //Update file LeadData.json
        leadtestdata.updateFieldValue("Additional Information", "SIC Code", "987654");

    }

    @Test(priority = 6, dependsOnMethods = {"verify_form_details"})
    public void update_form_details() {
        lead.click_form_details_action_toggle_and_click("Edit");
        lead.update_form_details();
        Assert.assertEquals(lead.getFormDetail(leaddata.getLeadInformation().getFax().getLabel()), leaddata.getLeadInformation().getFax().getValue());
        Assert.assertEquals(lead.getFormDetail(leaddata.getLeadInformation().getLeadStatus().getLabel()), leaddata.getLeadInformation().getLeadStatus().getValue());
    }

    @Test(priority = 7)
    public void verify_details_from_db() {
        Lead dblead = lead.verify_details_from_db();
        Assert.assertEquals(dblead.getFirstName(), leaddata.getLeadInformation().getFirstName().getValue());
        Assert.assertEquals(dblead.getLastName(), leaddata.getLeadInformation().getLastName().getValue());
        Assert.assertEquals(dblead.getStatus(), leaddata.getLeadInformation().getLeadStatus().getValue());
    }

}



















