package qa.test;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import qa.keywords.AccountAction;
import qa.keywords.LeadAction;
import qa.utils.TestDataSetup;
import qa.utils.WebDriverGenerator;
import sft.sfData.objectDescribe.GetFields;
import sft.forceObject.objField;
import sft.locators.Locators_Login;
import sft.utils.BaseActions;
import sft.utils.ConfigReader;

import java.io.File;
import java.util.Map;

public class BaseTestInitiator extends BaseActions {
    private static WebDriver driver = new WebDriverGenerator().remoteChromeDriver();

    objField sfField;
    //ActionClass
    LeadAction lead;
    AccountAction account;
    String baseURL;

    //DataClass
    TestDataSetup testdata;

    public Map<String, String> autoConfig;


    protected BaseTestInitiator() {
        super(driver);
        init();
    }

    private void init() {
//        leadtestdata = new TestDataSetup();
        lead = new LeadAction(driver);
        account = new AccountAction(driver);
        autoConfig = new ConfigReader(System.getProperty("user.dir") + File.separator + "autoSetup.json").getSetupDetails();
        baseURL = autoConfig.get("domain");
    }





    public void login(String username, String password) {
        launchUrl(autoConfig.get("domain"));
        webelement(Locators_Login.input_username).sendKeys(username);
        webelement(Locators_Login.input_password).sendKeys(password);
        click(Locators_Login.btn_login);
        hardwait(15);
    }

    public void verifyRequiredFields(TestDataSetup testData, String sfObject) {
        GetFields g = new GetFields(sfObject, null);
        Map<String, objField> formfield = g.getEditFields();
        for (JSONObject field : testData.getFields()) {
            try {
                System.out.println("Verified for : " + field.get("label") + "  " + field.get("value") + " " + field.get("isRequired"));
                objField itemField = formfield.get(field.get("label"));
                Assert.assertEquals(itemField.getRequired(), field.get("isRequired"), "isRequired verification failed for : " + field.get("label"));
                Reporter.log("isRequired verification for : "+itemField.getLabel());
            } catch (Exception e) {
            }
        }


    }

    @AfterTest
    public void tierDown() {
//        hardwait(10);
        driver.quit();
    }

}
