package sft.sfData.quickActions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sft.forceObject.ForceObject;
import sft.forceObject.objField;
import sft.forceObject.qaField;
import sft.sfData.BaseSFData;
import sft.sfData.quickActions.describeQuickActionsPOJO.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GetQAFields extends BaseSFData {
    private Describe actionObj;
    private WebDriver driver;
    GetSFQuickAction quickAction;
    qaField qaField = new qaField();
    private static Map<String, Details> edit_fields = new HashMap<String, Details>();

//    public GetQAFields() {
//    }

    public GetQAFields(String qaObj, WebDriver d) {
        super(d);
        quickAction = new GetSFQuickAction();
        editQuickAction(qaObj);
//        getObject(qaObj,d);
        driver = d;
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


    public static void main( String []args) {
//        WebDriver d = new ChromeDriver();
        GetQAFields test = new GetQAFields("Log a call",null);
//        edit_fields = test.getEditFields();
//        System.out.println(edit_fields.get(0).getLabel() + edit_fields.get(0).getType());
        System.out.println(edit_fields);
        test.print_map1(test.getEditFields());

    }

    public void print_map1(Map<String, Details> map) {
        Iterator<Map.Entry<String, Details>> itr = map.entrySet().iterator();
        System.out.print("\n\n");
        while (itr.hasNext()) {
            Map.Entry<String, Details> entry = itr.next();
            System.out.println(entry.getKey() + " : " + entry.getValue().getLabel() +" : "+ entry.getValue().getAggregatable() + " : "+entry.getValue().getType());
        }
        System.out.print("\n\n");
    }

//    public static void main(String []args){
//        WebDriver d;
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        d = new ChromeDriver(options);
//        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        d.manage().window().maximize();
//
//        GetQAFields test = new GetQAFields("Log a call",d);
//        edit_fields = test.getEditFields();
//        System.out.println(edit_fields.size());
//        for (Map.Entry<String, Details> entry : edit_fields.entrySet())
//        {  System.out.println("Key = " + entry.getKey() +
//                ", Value = " + entry.getValue().getType());
//        ForceObject o = null;
//        BaseSFData testt = new BaseSFData();
//        o = testt.getType(entry.getValue(),entry.getValue().getType());
//            System.out.println(o.get());
//        }
////        System.out.println(edit_fields.get(0).getLabel());
//    }

    public ForceObject getObject(String field, WebDriver d) {

        GetQAFields test = new GetQAFields(field,d);
        edit_fields = test.getEditFields();
        System.out.println(edit_fields.size());
        for (Map.Entry<String, Details> entry : edit_fields.entrySet())
        {  System.out.println("Key = " + entry.getKey() +
            ", Value = " + entry.getValue().getType());
            ForceObject o = null;
            BaseSFData testt = new BaseSFData();
            o = testt.getType(entry.getValue(),entry.getValue().getType());
            System.out.println(o.get());
        }
//        System.out.println("Getting object type for :" + field);
//        Details f;
//        String type = "default_case";
//        if ((f = edit_fields.get(field)) == null)
//            f = detail_fields.get(field);
//        if (f != null)
//            type = f.getDetails().getType();
//        else {
//            f = new Details();
//            f.setLabel(field);
//        }
//
        ForceObject o = null;
//        o = getType(f,type);
        return o;
    }
}
