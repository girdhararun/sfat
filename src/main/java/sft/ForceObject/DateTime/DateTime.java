package sft.ForceObject.DateTime;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import sft.DataFields;
import sft.ForceObject.ForceObject;
import sft.ForceObject.SFField;
import sft.utils.SFBase;

public class DateTime extends SFBase implements ForceObject
{

	protected String fieldName,domDataType;
	private SFField details;
	protected static Map<String,String> dataTypes = DataFields.fields();
	protected String span;
	public DateTime(SFField field,WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		details = field;
		fieldName = field.getLabel();
		domDataType = dataTypes.get(field.getDetails().getType());
		span = "//div[contains(@class, 'forcePageBlockSectionView')]//div[contains(@class, 'forcePageBlockSectionRow')]//div[contains(@class, 'forcePageBlockItem')]//div[contains(@class,'label')]/span[text()='"+fieldName+"']/../../div[last()]/span";
	}

	@Override
	public void set(String value) {
		System.out.println("[Alert] : Need to implement in DateTime");
		
	}

	@Override
	public String get() {
		WebElement textNode = null; 
		textNode = driver.findElement(By.xpath(span));
		return textNode.getText();
	}

	public void clear() {
		System.out.println("[Alert] : Need to implement in DateTime");
		
	}

}
