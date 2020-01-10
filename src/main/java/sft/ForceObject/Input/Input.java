package sft.ForceObject.Input;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sft.DataFields;
import sft.SFField;
import sft.ForceObject.ForceObject;
import sft.utils.SFUtils;


public class Input extends SFUtils implements ForceObject
{
	private String fieldName,domDataType;
	private WebDriver driver;
	private static Map<String,String> dataTypes = DataFields.fields();
	public Input(SFField field,WebDriver driver)
	{
		this.driver = driver;
		fieldName = field.getLabel();
		domDataType = dataTypes.get(field.getDetails().getType());
	}

	protected WebElement getWebElement() {

		List<WebElement> divs = driver.findElements(By.cssSelector("div[class *='"+ domDataType +"']"));
		int size = divs.size();
		for(int i=0; i<size; i++)
		{
			divs = driver.findElements(By.cssSelector("div[class *='"+ domDataType +"']"));
			WebElement div = divs.get(i);
			String spanText = div.findElement(By.cssSelector("span")).getText();
			if(spanText.equalsIgnoreCase(fieldName))
			{
				return div.findElement(By.cssSelector("input"));
			}
		}
		return null;
	}

	public void set(String value) 
	{
		getWebElement().sendKeys(value);
	}

	public void clear()
	{
		getWebElement().clear();
	}

}
