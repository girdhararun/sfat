package qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.utils.TestDataSetup;

public class headerActions extends BaseTestInitiator{


    @Test(priority=1)
    public void send_list_email_dropdown()
    {
//        Assert.assertEquals(lead.openObject("Leads"), "Leads");
//        lead.oneAction("Send List Email");
        lead.launchUrl("https://info123-dev-ed.lightning.force.com/lightning/r/Lead/00Q2v00001eItGMEA0/view");
        lead.oneAction("Delete");


    }
}
