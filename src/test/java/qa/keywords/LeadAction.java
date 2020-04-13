package qa.keywords;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Lead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import qa.utils.TestDataSetup;
import sft.sfData.objectDescribe.GetFields;
import sft.locators.Locators_Common;
import sft.keywords.objectHeader;
import sft.soql.ExecuteSOQL;
import sft.utils.BaseActions;

import java.util.List;

public class LeadAction extends BaseActions {
    public Locators_Common common = new Locators_Common();
    public GetFields leadFields;
    public objectHeader headActions;

    public LeadAction(WebDriver driver) {
        super(driver);
        leadFields = new GetFields("Lead", driver);
        headActions = new objectHeader(driver);
    }

    public GetFields getLeadFields() {
        return leadFields;
    }

    public String openObject(String sfObject) {
        navObject(sfObject);
        return webelement(Locators_Common.pageHeading, sfObject).getText();
    }

    public String openApp(String sfApp) {
        navApp(sfApp);
        return getPageTitle();
    }

    public String open_new_form() {
        waitForPageToLoadCompletely();
        click(Locators_Common.formDetailsActionToggle);
        click(headActions.getAction("Send List Email"));
//        click(Locators_Common.newForm);
        hardwait(5);
        List<WebElement> formTitles = webelementsWithoutVisibility(Locators_Common.formTitle);    //without

        for (WebElement e : formTitles) {
            if (e.isDisplayed())
                return e.getText();
        }
        return null;
    }

    public String fill_form_and_save(TestDataSetup testdata) {
//		fillCompleteForm(testdata.getFields(), leadFields);
        fillFormByParts(testdata.getFieldset("Lead Information"), leadFields);
        fillFormByParts(testdata.getFieldset("Address Information"), leadFields);
        fillFormByParts(testdata.getFieldset("Additional Information"), leadFields);
        fillFormByParts(testdata.getFieldset("Description Information"), leadFields);
        saveForm();
        return webelement(Locators_Common.newFormBearer).getText();
    }

    public void saveForm() {
        Reporter.log("Save Lead Details : ",2);
        clickUsingJavaScript(webelement(Locators_Common.saveForm));
        hardwait(1);
    }

    public String getFormDetail(String field) {
        return leadFields.getObject(field).get();
    }

    public void open_form_details() {
        click(Locators_Common.tabBar, "Details");
    }

    public void click_form_details_action_toggle_and_click(String action) {
        waitForPageToLoadCompletely();
        click(Locators_Common.formDetailsActionToggle);
        click(headActions.getAction(action));
    }

    public void updateFormDetail(TestDataSetup leadtestdata, String fieldSet, String label, String value) {
        leadtestdata.updateDataValue(fieldSet,label,value);
        leadFields.getObject(label).set(value);;
    }


    public Lead get_Lead_details_db(String email) {
        QueryResult qr;
        ExecuteSOQL db = new ExecuteSOQL();
        String query = "SELECT id,firstname,lastname,city,status,fax,phone,mobilephone,NumberOfEmployees,Rating FROM Lead Where email='" + email + "'";
        System.out.println(query);
        qr = db.ExecuteQuery(query);
        Lead lead = (Lead) qr.getRecords()[0];
        return lead;
    }


}
