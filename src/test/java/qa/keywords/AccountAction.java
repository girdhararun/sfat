package qa.keywords;

import org.openqa.selenium.WebDriver;
import sft.sfData.objectDescribe.GetFields;
import sft.utils.BaseActions;

public class AccountAction extends BaseActions{

	public AccountAction(WebDriver driver) {
		super(driver);
	}

	public GetFields accountFields = new GetFields("Account",driver);
}
