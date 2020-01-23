package sft.ForceObject.Input;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sft.DataFields;
import sft.ForceObject.ForceObject;
import sft.ForceObject.SFField;
import sft.utils.SFBase;


public class Input extends SFBase implements ForceObject
{
	protected String fieldName,domDataType;
	private SFField details;
	protected static Map<String,String> dataTypes = DataFields.fields();
	protected String span;
	public Input(SFField field,WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		details = field;
		fieldName = field.getLabel();
		domDataType = dataTypes.get(field.getDetails().getType());
		span = "//div[contains(@class, 'forcePageBlockSectionView')]//div[contains(@class, 'forcePageBlockSectionRow')]//div[contains(@class, 'forcePageBlockItem')]//div[contains(@class,'label')]/span[text()='"+fieldName+"']/../../div[last()]/span";
	}

	protected WebElement getWebElement() {

		List<WebElement> divs = driver.findElements(By.cssSelector("div[class *='"+ domDataType +"']"));
		int size = divs.size();
		for(int i=0; i<size; i++)
		{
			divs = driver.findElements(By.cssSelector("div[class *='"+ domDataType +"']"));
			WebElement div = divs.get(i);
			String spanText = div.findElement(By.cssSelector("span")).getText().replace('*',' ').trim();
			if(spanText.equalsIgnoreCase(fieldName))
			{
				return div.findElement(By.cssSelector("input"));
			}
		}
		return null;
	}

	public void set(String value) 
	{
		getWebElement().clear();
		getWebElement().sendKeys(value);
	}

	public void clear()
	{
		getWebElement().clear();
	}
	
	public String get() {	
		WebElement textNode = null; 
		textNode = driver.findElement(By.xpath(span));
		return textNode.getText();
	}
}