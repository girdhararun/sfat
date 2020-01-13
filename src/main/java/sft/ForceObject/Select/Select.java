package sft.ForceObject.Select;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sft.DataFields;
import sft.ForceObject.SFField;
import sft.ForceObject.ForceObject;
import sft.SFObject.describeLayoutPOJO.PicklistValue;
import sft.utils.SFBase;

public class Select extends SFBase implements ForceObject
{
	private String fieldName,domDataType;
	private WebDriver driver;
	private static Map<String,String> dataTypes = DataFields.fields();
	private SFField details;
	public Select(SFField field,WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		details = field;
		fieldName = field.getLabel();
		domDataType = dataTypes.get(field.getDetails().getType());
	}

	private void select(String value) {
		boolean found = false;
		List<WebElement> divs = driver.findElements(By.cssSelector("div[class *='"+ domDataType +"']"));
		for(WebElement div : divs)
		{
			String spanText = div.findElement(By.cssSelector("span")).getText().replace('*',' ').trim();
			if(spanText.equalsIgnoreCase(fieldName))
			{
				div.findElement(By.cssSelector("a")).click();hardwait(1);
				break;
			}
		}

		List<WebElement> options = driver.findElements(By.cssSelector("div[class*='select-options'][class*='visible'] ul li a"));
		int size = options.size();
		for(int i=0; i<size; i++)
		{
			options = driver.findElements(By.cssSelector("div[class*='select-options'][class*='visible'] ul li a"));
			WebElement option = options.get(i);
			if(option.getText().equalsIgnoreCase(value))
			{
				option.click();hardwait(1);
				found = true;
				break;
			}
		}

		if(!found) 
		{
			System.out.println("Availabel options for field \"" + fieldName +"\" are :");
			List<PicklistValue> picklist= details.getDetails().getPicklistValues();
			for(int j=0; j<picklist.size();j++)
				System.out.println("\t\t" + picklist.get(j).getLabel());
			Assert.fail();
		}
	}

	public void set(String value) {
		select(value);
	}

	public void clear() {

	}
}
