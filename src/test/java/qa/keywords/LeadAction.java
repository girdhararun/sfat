package qa.keywords;

import java.util.Map;
import org.openqa.selenium.By;
import qa.utils.BaseAction;
import qa.utils.JsonReader;
import sft.GetFields;
import sft.auth.SftSetup;

public class LeadAction extends BaseAction
{
	private GetFields leadFields = new GetFields("Lead",driver);
	
	public String login(String username, String password)
	{
		launchUrl(SftSetup.getSftSetup().get("domain_url"));
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(username);
		driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(password);
		click(driver.findElement(By.cssSelector("input[id=\"Login\"]")));
		hardwait(5);
		return driver.getTitle();
	}
	
	public void app_launch(String app)
	{
		click((By.cssSelector("nav button[class *= \"AppLauncher\"]")));
		click(By.xpath("//div[contains(@class,\"dragArea\")]//a[text()=\""+app+"\"]"));
		waitForPageToLoadCompletely();
		hardwait(5);
	}
	
	
	public void open_lead_form()
	{
		click_js("a[title='Leads']");
		click(By.cssSelector("a[title=\"New\"]"));
		hardwait(2);
	}
	
	public void fill_form()
	{
		JsonReader lead_data  = new JsonReader("LeadData.json");
		fillCompleteForm(lead_data.read_asJSONObject(), leadFields);		
	}
}
