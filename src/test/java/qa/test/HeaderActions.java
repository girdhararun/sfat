package qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderActions extends BaseTestInitiator{

    @Test(priority = 1)
    public void checkLeadObjectVisibleAction()
    {
        Assert.assertEquals(lead.openObject("Leads"), "Leads");
        lead.oneAction("New");
        Assert.assertEquals(lead.getModalHeading(),"New Lead", "Unable to open New Lead Modal");
        lead.closeModal();
    }

    @Test(priority = 2)
    public void checkLeadObjectHiddenAction(){
        lead.oneAction("Send List Email");
        Assert.assertEquals(lead.getModalHeading(),"Send List Email", "Unable to open New Lead Modal");
        lead.closeModal();
    }

    @Test(priority = 3)
    public void checkDataVisibleAction(){
        lead.launchUrl(baseURL+"/lightning/r/Lead/00Q2v00001eItGMEA0/view");
        lead.oneAction("New Case");
        Assert.assertEquals(lead.getModalHeading(),"New Case", "Unable to open New Case Modal");
        lead.closeModal();
    }

    @Test(priority = 4)
    public void checkDataHiddenAction(){
        lead.oneAction("Delete");
        Assert.assertEquals(lead.getModalHeading(),"Delete Lead", "Unable to open Delete lead Modal");
        lead.closeModal();
    }

    @Test(priority = 5)
    public void checkAccountObjectVisibleAction()
    {
        Assert.assertEquals(lead.openObject("Accounts"), "Accounts");
        lead.oneAction("New");
        Assert.assertEquals(lead.getModalHeading(),"New Account", "Unable to open New Account Modal");
        lead.closeModal();
    }

}
