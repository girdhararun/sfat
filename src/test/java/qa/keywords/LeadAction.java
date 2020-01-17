package qa.keywords;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	
	public void open_lead_tab()
	{
		click_js("a[title='Leads']");
	}
	
	public void open_lead_details()
	{
		click(By.xpath("//a[@class='tabHeader']/span[text()='Details']/..//self::a"));
	}
	
	public void open_lead_form()
	{
		open_lead_tab();
		click(By.cssSelector("a[title=\"New\"]"));
		hardwait(2);
	}
	
	public void fill_form()
	{
		JsonReader lead_data  = new JsonReader("LeadData.json");
		fillCompleteForm(lead_data.read_asJSONObject(), leadFields);		
	}
	
	public void openLead(String name)
	{
		click(By.cssSelector("a[title='"+ name +"']"));
	}
	
	public void lead_details()
	{
		int rows = driver.findElements(By.cssSelector("div[class*='forcePageBlockSection'][class*='forcePageBlockSectionView'] div[class *='forcePageBlockSectionRow']")).size();
		
		LeadDetails[][] arr = new LeadDetails[rows][2];
		
		List<WebElement> labels = driver.findElements(By.cssSelector("div[class*='forcePageBlockSection'][class*='forcePageBlockSectionView'] div[class *='forcePageBlockSectionRow'] div[class *= 'forcePageBlockItem'] div[class *= 'label']>span"));
		List<WebElement> details = driver.findElements(By.cssSelector("div[class*='forcePageBlockSection'][class*='forcePageBlockSectionView'] div[class *='forcePageBlockSectionRow'] div[class *= 'forcePageBlockItem'] div[class *= 'itemBody']>span"));
		
		int label_size = labels.size();
		System.out.println("rows="+rows+ " label="+labels.size()+ " details="+details.size());
		
		for(int i=0,c=0; i<rows; i++)
		{
			for(int j=0; j<2; j++)
			{
				arr[i][j] = new LeadDetails();
				
				if(c<label_size) 
				{
					arr[i][j].label = labels.get(c).getText();
					arr[i][j].value = details.get(c).getText();
				}
				
				c++;
			}
		}
		
		
		for(int i=0,c=0; i<rows; i++)
		{
			for(int j=0; j<2; j++)
			{
				System.out.println(arr[i][j].label + " : " + arr[i][j].value);
			}
		}
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


class LeadDetails
{
	public String label=null;
	public String value=null;
}
