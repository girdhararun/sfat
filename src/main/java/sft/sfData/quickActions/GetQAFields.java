package sft.sfData.quickActions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import sft.forceObject.objField;
import sft.forceObject.qaField;
import sft.sfData.quickActions.describeQuickActionsPOJO.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetQAFields {
    private Describe actionObj;
    private WebDriver driver;
    GetSFQuickAction quickAction;
    qaField qaField = new qaField();
    private static Map<String, Details> edit_fields = new HashMap<String, Details>();

    public GetQAFields() {
    }

    public GetQAFields(String qaObj) {
        quickAction = new GetSFQuickAction();
        editQuickAction(qaObj);

    }

    public Map<String, Details> getEditFields() {
        return edit_fields;
    }


    private void editQuickAction(String action) {
        actionObj = quickAction.getAction(action);
        String label;
        List<LayoutRow> layoutRows = actionObj.getLayout().getLayoutRows();
        for (LayoutRow row : layoutRows) {
            List<LayoutItem> layoutItems = row.getLayoutItems();
            for (LayoutItem layoutItem : layoutItems) {
                List<LayoutComponent> layoutComponents = layoutItem.getLayoutComponents();
                label = layoutItem.getLabel();
                for (LayoutComponent layoutComponent : layoutComponents) {
                    edit_fields.put(label, layoutComponent.getDetails());
                }
            }
        }
    }

    @Test
    public void check_QuickField_Details_Received() {
        GetQAFields test = new GetQAFields("Log a call");
        edit_fields = test.getEditFields();
        System.out.println(edit_fields.get(0).getLabel() + edit_fields.get(0).getType());
    }

    public static void main(String []args){
        GetQAFields test = new GetQAFields("Log a call");
        edit_fields = test.getEditFields();
        System.out.println(edit_fields.size());
        for (Map.Entry<String, Details> entry : edit_fields.entrySet())
            System.out.println("Key = " + entry.getKey() +
                ", Value = " + entry.getValue().getType());
//        System.out.println(edit_fields.get(0).getLabel());
    }
}
