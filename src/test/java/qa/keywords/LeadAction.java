package qa.keywords;

import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Lead;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.utils.TestDataSetup;
import sft.GetFields;
import sft.locators.Locators_Common;
import sft.soql.ExecuteSOQL;
import sft.utils.BaseActions;

import java.util.List;

public class LeadAction extends BaseActions {
    public Locators_Common common = new Locators_Common();
    public GetFields leadFields;

    public LeadAction(WebDriver driver) {
        super(driver);
        leadFields = new GetFields("Lead", driver);
    }

    public GetFields getLeadFields() {
        return leadFields;
    }

    public String app_launch(String app) {
        click(Locators_Common.btn_appLauncher);
        click(Locators_Common.btn_Sales, app);
        waitForPageToLoadCompletely();
        waitForVisibilityOfElement(Locators_Common.appName);
        return webelement(Locators_Common.appName).getText();
    }

    public String openObject(String sfObject) {
//		clickUsingJavaScript(webelement(Header_ONav.navigation_tab, tab));

        navObject(sfObject);
        return webelement(Locators_Common.pageHeading, sfObject).getText();
    }

    public String openApp(String sfApp) {
        navApp(sfApp);
        return getPageTitle();
    }

    public String open_new_form() {
        click(Locators_Common.newForm);
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
        saveForm();
        return webelement(Locators_Common.newFormBearer).getText();
    }

    public void saveForm() {
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
        click(Locators_Common.formDetailsActionToggleActions, action);
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
