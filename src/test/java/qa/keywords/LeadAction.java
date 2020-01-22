package qa.keywords;

import java.util.List;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import qa.resources.locators.Locators_Common;
import qa.resources.locators.Locators_Login;
import qa.utils.BaseAction;
import sft.GetFields;
import sft.auth.SftSetup;

public class LeadAction extends BaseAction
{
	private GetFields leadFields = new GetFields("Lead",driver);
	public void login(String username, String password)
	{
		launchUrl(SftSetup.getSftSetup().get("domain_url"));
		webelement(Locators_Login.input_username).sendKeys(username);
		webelement(Locators_Login.input_password).sendKeys(password);
		click(Locators_Login.btn_login);
		hardwait(15);
	}
	public String app_launch(String app)
	{
		click(Locators_Common.btn_appLauncher);
		click(getXpathLocator(Locators_Common.btn_Sales, app));
		waitForPageToLoadCompletely();
		hardwait(5);
		return webelement(Locators_Common.appName).getText();
	}
	public String open_tab(String tab)
	{
		clickUsingJavaScript(webelement(getCSSLocator(Locators_Common.tab, tab)));
		return webelement(getXpathLocator(Locators_Common.pageHeading, tab)).getText();
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
	public String fill_form_and_save(List<JSONObject> fields)
	{
		fillCompleteForm(fields, leadFields);
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
	
	
	public void openLead(String name)
	{
		click(By.cssSelector("a[title='"+ name +"']"));
	}
}
