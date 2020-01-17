package sft.ForceObject.TextArea;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sft.DataFields;
import sft.ForceObject.SFField;
import sft.ForceObject.ForceObject;
import sft.utils.SFBase;

public class TextArea extends SFBase implements ForceObject
{

	private String fieldName,domDataType;
	private WebDriver driver;
	private SFField details;
	private static Map<String,String> dataTypes = DataFields.fields();

	public TextArea(SFField field,WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		details = field;
		fieldName = field.getLabel();
		domDataType = dataTypes.get(field.getDetails().getType());
	}

	private WebElement getWebElement() {
		List<WebElement> divs = driver.findElements(By.cssSelector("div[class *='"+ domDataType +"']"));
		int size = divs.size();
		for(int i=0; i < size; i++)
		{
			divs = driver.findElements(By.cssSelector("div[class *='"+ domDataType +"']"));
			WebElement div = divs.get(i);
			String spanText = div.findElement(By.cssSelector("span")).getText();
			if(spanText.equalsIgnoreCase(fieldName))
				return div.findElement(By.cssSelector("textarea"));
		}
		return null;
	}

	public void set(String value) 
	{
		getWebElement().sendKeys(value, Keys.ENTER);
	}

	public void clear()
	{
		getWebElement().clear();
	}

	@Override
	public String get() {
		WebElement textNode = null; 
		String span = "//div[contains(@class, 'forcePageBlockSectionView')]//div[contains(@class, 'forcePageBlockSectionRow')]//div[contains(@class, 'forcePageBlockItem')]//div[contains(@class,'label')]/span[text()='"+fieldName+"']/../../div[last()]/span";
		textNode = driver.findElement(By.xpath(span));
		return textNode.getText();
	}

}
