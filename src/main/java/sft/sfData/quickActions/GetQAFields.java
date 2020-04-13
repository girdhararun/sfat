package sft.sfData.quickActions;

import org.openqa.selenium.WebDriver;
import sft.forceObject.objField;
import sft.forceObject.qaField;
import sft.sfData.quickActions.describeQuickActionsPOJO.*;

import java.util.List;

public class GetQAFields {
    private Describe actionObj;
    private WebDriver driver;
    GetSFQuickAction quickAction;
    qaField qaField = new qaField();

    public GetQAFields(String qaObj, WebDriver d) {
        driver = d;
        quickAction = new GetSFQuickAction();
        actionObj = quickAction.getAction(qaObj);
    }

    private void editQuickAction(String action) {
        List<LayoutRow> layoutRows = actionObj.getLayout().getLayoutRows();
        for (LayoutRow row : layoutRows) {
            List<LayoutItem> layoutItems = row.getLayoutItems();
            for (LayoutItem layoutItem : layoutItems) {
                List<LayoutComponent> layoutComponents = layoutItem.getLayoutComponents();
                for (LayoutComponent layoutComponent : layoutComponents){
                    layoutComponent.getDetails();
                    qaField.setDetails(layoutComponent.getDetails());
                }
            }
        }
    }
}
