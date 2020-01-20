package qa.keywords;

import java.util.List;
import org.json.JSONObject;
import org.openqa.selenium.By;
import qa.utils.BaseAction;
import qa.utils.JsonIO;
import sft.GetFields;
import sft.auth.SftSetup;

public class LeadAction extends BaseAction
{
	private GetFields leadFields = new GetFields("Lead",driver);
	
	private List<JSONObject> fields;
	
	public void login(String username, String password)
	{
		launchUrl(SftSetup.getSftSetup().get("domain_url"));
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(password);
		click(driver.findElement(By.cssSelector("input[id=\"Login\"]")));
		hardwait(10);
	}

	
	public String app_launch(String app)
	{
		click((By.cssSelector("nav button[class *= \"AppLauncher\"]")));
		click(By.xpath("//div[contains(@class,\"dragArea\")]//a[text()=\""+app+"\"]"));
		waitForPageToLoadCompletely();
		hardwait(5);
		return "";
		//return driver.findElement(By.cssSelector("span[class*='appName']")).getText();
	}
	
	
	public void open_lead_tab()
	{
		click_js("a[title='Leads']");
	}
	
	public void open_lead_details()
	{
		click(By.xpath("//a[@class='tabHeader']/span[text()='Details']/..//self::a"));
	}
	
	public void open_new_lead_form()
	{
		open_lead_tab();
		click(By.cssSelector("a[title=\"New\"]"));
		hardwait(2);
	}
	
	public void fill_form_and_save(List<JSONObject> fields)
	{
		fillCompleteForm(fields, leadFields);
		click_js("div[class*='forceDetailPanelDesktop']");
		hardwait(1);
		click_js("button[title='Save']");
	}
	
	public void openLead(String name)
	{
		click(By.cssSelector("a[title='"+ name +"']"));
	}
	
	public String getFormDetail(String field)
	{
		return leadFields.getObject(field).get();
	}
	
	public void detail_test()
	{
		System.out.println("Description -> " + leadFields.getObject("Description").get());
		System.out.println("Number of Locations -> " + leadFields.getObject("Number of Locations").get());
		System.out.println("Phone -> " + leadFields.getObject("Phone").get());
		System.out.println("Email -> " + leadFields.getObject("Email").get());
		System.out.println("Lead Owner -> " + leadFields.getObject("Lead Owner").get());
		System.out.println("Rating -> " + leadFields.getObject("Rating").get());
		System.out.println("SIC Code -> " + leadFields.getObject("SIC Code").get());
		System.out.println("Created By -> " + leadFields.getObject("Created By").get());
		System.out.println("Last Modified By -> " + leadFields.getObject("Last Modified By").get());
		System.out.println("Address -> " + leadFields.getObject("Address").get());
		
	}
}
