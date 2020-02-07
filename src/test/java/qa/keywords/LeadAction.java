package qa.keywords;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Lead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.utils.TestDataSetup;
import sft.GetFields;
import sft.SOQL.ExecuteSOQL;
import sft.locators.Header_ONav;
import sft.locators.Locators_Common;
import sft.utils.BaseActions;

import java.util.List;

public class LeadAction extends BaseActions
{
    public Locators_Common common = new Locators_Common();
	TestDataSetup leadtestdata;
	public LeadAction(WebDriver driver,TestDataSetup leadtestdata) {
		super(driver);
		this.leadtestdata = leadtestdata;
	}

	public GetFields leadFields = new GetFields("Lead",driver);

	public String app_launch(String app)
	{
		click(Locators_Common.btn_appLauncher);
		click(Locators_Common.btn_Sales, app);
		waitForPageToLoadCompletely();
		waitForVisibilityOfElement(Locators_Common.appName);
		return webelement(Locators_Common.appName).getText();
	}

	public String open_tab(String tab)
	{
		clickUsingJavaScript(webelement(Header_ONav.navigation_tab, tab));
		return webelement(Locators_Common.pageHeading, tab).getText();
	}
	public String open_new_form()
	{
		click(Locators_Common.newForm);
		hardwait(5);
		List<WebElement> formTitles = webelementsWithoutVisibility(Locators_Common.formTitle);	//without
		
		for(WebElement e : formTitles)
		{
			if(e.isDisplayed())
				return e.getText();
		}
		return null;
	}
	public String fill_form_and_save(TestDataSetup testdata)
	{
//		fillCompleteForm(testdata.getFields(), leadFields);
		fillFormByParts(testdata.getFieldset("Lead Information"),leadFields);
		fillFormByParts(testdata.getFieldset("Address Information"),leadFields);
		System.out.println(">>>>>>>>>>>>>>>>>" + leadFields.getObject("Street").edit_get());
		System.out.println(">>>>>>>>>>>>>>>>>" + leadFields.getObject("Salutation").edit_get());
		System.out.println(">>>>>>>>>>>>>>>>>" + leadFields.getObject("Phone").edit_get());
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
		leadtestdata.updateFieldValue("Lead Information","Fax","654321");
		leadFields.getObject("Lead Status").set("Closed - Converted");
		leadtestdata.updateFieldValue("Lead Information","Lead Status","Closed - Converted");
		clickUsingJavaScript(webelement(Locators_Common.saveForm));
		hardwait(2);
	}
	
	public Lead verify_details_from_db()
	{
		QueryResult qr;
        ExecuteSOQL db = new ExecuteSOQL();
        String query = "SELECT id,firstname,lastname,city,status,fax,phone,mobilephone,NumberOfEmployees,Rating FROM Lead Where email='"+leadtestdata.getFieldValue("Lead Information","Email")+"'";
        System.out.println(query);
        qr = db.ExecuteQuery(query);
        Lead lead = (Lead) qr.getRecords()[0];
        return lead;
	}
}
