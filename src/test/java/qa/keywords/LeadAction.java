package qa.keywords;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Lead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pojos.leaddata.LeadData;
import qa.resources.locators.Locators_Common;
import qa.utils.BaseAction;
import qa.utils.TestDataSetup;
import sft.GetFields;
import sft.SOQL.ExecuteSOQL;

import java.util.List;

public class LeadAction extends BaseAction
{
	private LeadData leaddata=null;
	public LeadAction(WebDriver driver,LeadData leaddata) {
		super(driver);
		this.leaddata = leaddata;
	}
	public GetFields leadFields = new GetFields("Lead",driver);

	public String app_launch(String app)
	{
		click(Locators_Common.btn_appLauncher);
		click(Locators_Common.btn_Sales, app);
		waitForPageToLoadCompletely();
		hardwait(5);
		return webelement(Locators_Common.appName).getText();
	}
	public String open_tab(String tab)
	{
		clickUsingJavaScript(webelement(Locators_Common.tab, tab));
		return webelement(Locators_Common.pageHeading, tab).getText();
	}
	public String open_new_form()
	{
		click(Locators_Common.newForm);
		List<WebElement> formTitles = webelements(Locators_Common.formTitle);
		
		for(WebElement e : formTitles)
		{
			if(e.isDisplayed())
				return e.getText();
		}
		return null;
	}
	public String fill_form_and_save(TestDataSetup testdata)
	{
		fillCompleteForm(testdata.getFields(), leadFields);
		clickUsingJavaScript(webelement(Locators_Common.saveForm));
		return webelement(Locators_Common.newFormBearer).getText();
	}
	public String getFormDetail(String field)
	{
		return leadFields.getObject(field).get();
	}
	public void open_form_details()
	{
		click(Locators_Common.formDetails);
	}
	
	public void click_form_details_action_toggle_and_click(String action)
	{
		click(Locators_Common.formDetailsActionToggle);
		click(Locators_Common.formDetailsActionToggleActions,action);
	}
	
	public void update_form_details()
	{
		leadFields.getObject("Fax").set("654321");
		leaddata.getLeadInformation().getFax().setValue("654321");
		
		leadFields.getObject("Lead Status").set("Closed - Converted");
		leaddata.getLeadInformation().getLeadStatus().setValue("Closed - Converted");
		
		clickUsingJavaScript(webelement(Locators_Common.saveForm));
		hardwait(2);
	}
	
	public Lead verify_details_from_db()
	{
		QueryResult qr;
        ExecuteSOQL db = new ExecuteSOQL();
        String query = "SELECT id,firstname,lastname,city,status,fax,phone,mobilephone,NumberOfEmployees,Rating FROM Lead Where email='"+leaddata.getLeadInformation().getEmail().getValue()+"'";
        System.out.println(query);
        qr = db.ExecuteQuery(query);
        Lead lead = (Lead) qr.getRecords()[0];
        return lead;
	}
}
