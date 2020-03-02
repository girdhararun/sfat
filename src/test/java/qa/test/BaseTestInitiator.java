package qa.test;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import qa.keywords.AccountAction;
import qa.keywords.LeadAction;
import qa.resources.Config;
import qa.utils.TestDataSetup;
import qa.utils.WebDriverGenerator;
import sft.GetFields;
import sft.forceObject.SFField;
import sft.locators.Locators_Login;
import sft.utils.BaseActions;

import java.util.Map;

public class BaseTestInitiator extends BaseActions {
    private static WebDriver driver = new WebDriverGenerator().getChromeDriver();

    SFField sfField;
    //ActionClass
    LeadAction lead;
    AccountAction account;

    //DataClass
    TestDataSetup leadtestdata;

    protected BaseTestInitiator() {
        super(driver);
        init();
    }

    private void init() {
        leadtestdata = new TestDataSetup("LeadData.json");
        lead = new LeadAction(driver, leadtestdata);
        account = new AccountAction(driver);
    }

    public void login(String username, String password) {
        launchUrl(Config.domain);
        webelement(Locators_Login.input_username).sendKeys(username);
        webelement(Locators_Login.input_password).sendKeys(password);
        click(Locators_Login.btn_login);
        hardwait(15);
    }

    public void verifyRequiredFields(TestDataSetup testData, String sfObject) {
        GetFields g = new GetFields(sfObject, null);
        Map<String, SFField> formfield = g.getEditFields();
                for (JSONObject field : testData.getFields()) {
                    try{
                    System.out.println("Verified for : "+field.get("label") + "  " + field.get("value") +" "+field.get("isRequired"));
                        SFField itemField = formfield.get(field.get("label"));
                        Assert.assertEquals(itemField.getRequired(),field.get("isRequired"),"isRequired verification failed for : "+field.get("label"));
                }catch (Exception e){
                    }
                }


    }


}
