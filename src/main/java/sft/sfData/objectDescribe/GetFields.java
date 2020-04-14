package sft.sfData.objectDescribe;

import org.openqa.selenium.WebDriver;
import sft.forceObject.Checkbox.CheckBox;
import sft.forceObject.DateTime.DateTime;
import sft.forceObject.DefaultCase.DefaultCase;
import sft.forceObject.ForceObject;
import sft.forceObject.Input.*;
import sft.forceObject.objField;
import sft.forceObject.Select.Select;
import sft.forceObject.TextArea.TextArea;
import sft.sfData.BaseSFData;
import sft.sfData.objectDescribe.describeLayoutPOJO.*;

import java.util.*;
import java.util.Map.Entry;

public final class GetFields extends BaseSFData {

    private WebDriver driver;
    private static Map<String, objField> edit_fields = new HashMap<String, objField>();
    private static Map<String, objField> detail_fields = new HashMap<String, objField>();

    public GetFields(String obj, WebDriver d) {
        editGenerater(obj);
        detailGenerater(obj);
        driver = d;
    }

    public static void main(String[] arags) {
        GetFields g = new GetFields("Lead", null);
        g.print_map(g.getDetailFields());
    }

    public Map<String, objField> getEditFields() {
        return edit_fields;
    }



    public Map<String, objField> getDetailFields() {
        return detail_fields;
    }

    private void editGenerater(String obj) {
        SFVFDescription sobj = GetSFObject.get(obj);
        List<Layout> layouts = sobj.getLayouts();
        for (int i = 0; i < layouts.size(); i++) {
            List<EditLayoutSection> editLayoutSections = layouts.get(i).getEditLayoutSections();

            for (int j = 0; j < editLayoutSections.size(); j++) {
                String fieldset = editLayoutSections.get(j).getHeading();
                Boolean collapsedSection = editLayoutSections.get(j).getUseCollapsibleSection();
                Boolean collapse = editLayoutSections.get(j).getCollapsed();
                List<LayoutRow__1> layoutRows = editLayoutSections.get(j).getLayoutRows();

                for (int k = 0; k < layoutRows.size(); k++) {
                    List<LayoutItem__1> layoutItems = layoutRows.get(k).getLayoutItems();

                    for (int l = 0; l < layoutItems.size(); l++) {

                        objField df = new objField();
                        df.setFieldsData(fieldset, layoutItems.get(l).getLabel(), layoutItems.get(l).getEditableForNew(),
                            layoutItems.get(l).getEditableForUpdate(), layoutItems.get(l).getPlaceholder(),
                            layoutItems.get(l).getRequired(), collapsedSection, collapse, null, null);

                        List<LayoutComponent__1> layoutComponents = layoutItems.get(l).getLayoutComponents();
                        for (int m = 0; m < layoutComponents.size(); m++) {
                            Details details = layoutComponents.get(m).getDetails();
                            df.setDetails(layoutComponents.get(m).getDetails());
                            List<Component__1> components = layoutComponents.get(m).getComponents();
                            if (components.size() != 0) {
                                for (int z = 0; z < components.size(); z++) {
                                    objField df2 = new objField();
                                    df2.setFieldsData(fieldset,
                                        components.get(z).getDetails().getLabel(), layoutItems.get(l).getEditableForNew(),
                                        layoutItems.get(l).getEditableForUpdate(), layoutItems.get(l).getPlaceholder(),
                                        layoutItems.get(l).getRequired(), collapsedSection, collapse, true, components.get(z).getDetails());

                                    edit_fields.put(df2.getLabel(), df2);
                                }
                            } else {
                                edit_fields.put(df.getLabel(), df);
                            }
                        }
                    }
                }
            }
        }
    }


    private void detailGenerater(String obj) {
        SFVFDescription sobj = GetSFObject.get(obj);
        List<Layout> layouts = sobj.getLayouts();
        for (int i = 0; i < layouts.size(); i++) {
            List<DetailLayoutSection> detailLayoutSections = layouts.get(i).getDetailLayoutSections();

            for (int j = 0; j < detailLayoutSections.size(); j++) {
                String fieldset = detailLayoutSections.get(j).getHeading();
                Boolean collapsedSection = detailLayoutSections.get(j).getUseCollapsibleSection();
                Boolean collapse = detailLayoutSections.get(j).getCollapsed();
                List<LayoutRow> layoutRows = detailLayoutSections.get(j).getLayoutRows();

                for (int k = 0; k < layoutRows.size(); k++) {
                    List<LayoutItem> layoutItems = layoutRows.get(k).getLayoutItems();

                    for (int l = 0; l < layoutItems.size(); l++) {

                        objField df = new objField();
                        df.setFieldsData(fieldset, layoutItems.get(l).getLabel(), layoutItems.get(l).getEditableForNew(),
                            layoutItems.get(l).getEditableForUpdate(), layoutItems.get(l).getPlaceholder(),
                            layoutItems.get(l).getRequired(), collapsedSection, collapse, null, null);

                        List<LayoutComponent> layoutComponents = layoutItems.get(l).getLayoutComponents();
                        for (int m = 0; m < layoutComponents.size(); m++) {
                            Details details = layoutComponents.get(m).getDetails();
                            df.setDetails(layoutComponents.get(m).getDetails());
                            List<Component> components = layoutComponents.get(m).getComponents();
                            if (components.size() != 0) {
                                for (int z = 0; z < components.size(); z++) {
                                    objField df2 = new objField();
                                    df2.setFieldsData(fieldset,
                                        components.get(z).getDetails().getLabel(), layoutItems.get(l).getEditableForNew(),
                                        layoutItems.get(l).getEditableForUpdate(), layoutItems.get(l).getPlaceholder(),
                                        layoutItems.get(l).getRequired(), collapsedSection, collapse, true, components.get(z).getDetails());

                                    detail_fields.put(df2.getLabel(), df2);
                                }
                            } else {
                                detail_fields.put(df.getLabel(), df);
                            }
                        }
                    }
                }
            }
        }
    }

    public ForceObject getObject(String field) {
        System.out.println("Getting object type for :" + field);
        objField f;
        String type = "default_case";
        if ((f = edit_fields.get(field)) == null)
            f = detail_fields.get(field);
        if (f != null)
            type = f.getDetails().getType();
        else {
            f = new objField();
            f.setLabel(field);
        }

        ForceObject o = null;
       o = getType(f,type);
        return o;
    }


}
