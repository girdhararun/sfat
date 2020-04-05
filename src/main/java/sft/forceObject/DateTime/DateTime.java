package sft.forceObject.DateTime;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import sft.sfData.ObjDataFields;
import sft.forceObject.ForceObject;
import sft.forceObject.objField;
import sft.locators.Locators_Get;
import sft.utils.BaseActions;

public class DateTime extends BaseActions implements ForceObject
{

	protected String fieldName,domDataType;
	private objField details;
	protected static Map<String,String> dataTypes = ObjDataFields.fields();
	protected String span;
	public DateTime(objField field, WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		details = field;
		fieldName = field.getLabel();
		domDataType = dataTypes.get(field.getDetails().getType());
	}

	@Override
	public void set(String value) {
		System.out.println("[Alert] : Need to implement in DateTime");

	}

	@Override
	public String get() {
		return webelement(Locators_Get.getEmail_ReferenceDetailUI,fieldName).getText();
	}

	public void clear() {
		System.out.println("[Alert] : Need to implement in DateTime");
	}

	@Override
	public String edit_get() {
		// TODO Auto-generated method stub
		return null;
	}

}
