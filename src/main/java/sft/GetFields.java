package sft;

import org.openqa.selenium.WebDriver;
import sft.forceObject.Checkbox.CheckBox;
import sft.forceObject.DateTime.DateTime;
import sft.forceObject.DefaultCase.DefaultCase;
import sft.forceObject.ForceObject;
import sft.forceObject.Input.*;
import sft.forceObject.SFField;
import sft.forceObject.Select.Select;
import sft.forceObject.TextArea.TextArea;
import sft.sFObject.GetSFObject;
import sft.sFObject.describeLayoutPOJO.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class GetFields {

	private WebDriver driver;
	private  static Map<String,SFField>  edit_fields = new HashMap<String, SFField>();
	private  static Map<String,SFField>  detail_fields = new HashMap<String, SFField>();
	public GetFields(String obj, WebDriver d)
	{
		editGenerater(obj);
		detailGenerater(obj);
		driver = d;
	}
	
	public static void main(String []arags)
	{
		GetFields g = new GetFields("Lead", null);
		g.print_map(g.getDetailFields());
	}
	
	public Map<String,SFField> getEditFields()
	{
		return edit_fields;
	}
	
	public Map<String,SFField> getDetailFields()
	{
		return detail_fields;
	}

	private  void editGenerater(String obj)
	{
		SFVFDescription sobj = GetSFObject.get(obj);
		List<Layout> layouts= sobj.getLayouts();
		for(int i=0; i< layouts.size(); i++)
		{
			List<EditLayoutSection> editLayoutSections = layouts.get(i).getEditLayoutSections();

			for(int j=0; j<editLayoutSections.size(); j++)
			{
				String fieldset = editLayoutSections.get(j).getHeading();
				Boolean collapsedSection = editLayoutSections.get(j).getUseCollapsibleSection();
				Boolean collapse = editLayoutSections.get(j).getCollapsed();
				List<LayoutRow__1> layoutRows = editLayoutSections.get(j).getLayoutRows();

				for(int k=0; k<layoutRows.size();k++)
				{
					List<LayoutItem__1> layoutItems = layoutRows.get(k).getLayoutItems();

					for(int l=0; l<layoutItems.size(); l++)
					{

						SFField df = new SFField();
						df.setFieldsData(fieldset, layoutItems.get(l).getLabel(), layoutItems.get(l).getEditableForNew(), 
								layoutItems.get(l).getEditableForUpdate(), layoutItems.get(l).getPlaceholder(), 
								layoutItems.get(l).getRequired(), collapsedSection, collapse, null, null);

						List<LayoutComponent__1>  layoutComponents = layoutItems.get(l).getLayoutComponents();
						for(int m=0; m<layoutComponents.size();m++)
						{
							Details details = layoutComponents.get(m).getDetails();
							df.setDetails(layoutComponents.get(m).getDetails());
							List<Component__1> components= layoutComponents.get(m).getComponents();
							if(components.size() != 0)
							{
								for(int z=0; z<components.size();z++)
								{
									SFField df2 = new SFField();
									df2.setFieldsData(fieldset,
											components.get(z).getDetails().getLabel(),layoutItems.get(l).getEditableForNew(),
											layoutItems.get(l).getEditableForUpdate(),layoutItems.get(l).getPlaceholder(),
											layoutItems.get(l).getRequired(),collapsedSection,collapse,true,components.get(z).getDetails());

									edit_fields.put(df2.getLabel(), df2);
								}
							}
							else{	edit_fields.put(df.getLabel(), df);}
						}
					}	
				}	
			}
		}
	}

	
	private  void detailGenerater(String obj)
	{
		SFVFDescription sobj = GetSFObject.get(obj);
		List<Layout> layouts= sobj.getLayouts();
		for(int i=0; i< layouts.size(); i++)
		{
			List<DetailLayoutSection> detailLayoutSections = layouts.get(i).getDetailLayoutSections();

			for(int j=0; j<detailLayoutSections.size(); j++)
			{
				String fieldset = detailLayoutSections.get(j).getHeading();
				Boolean collapsedSection = detailLayoutSections.get(j).getUseCollapsibleSection();
				Boolean collapse = detailLayoutSections.get(j).getCollapsed();
				List<LayoutRow> layoutRows = detailLayoutSections.get(j).getLayoutRows();

				for(int k=0; k<layoutRows.size();k++)
				{
					List<LayoutItem> layoutItems = layoutRows.get(k).getLayoutItems();

					for(int l=0; l<layoutItems.size(); l++)
					{

						SFField df = new SFField();
						df.setFieldsData(fieldset, layoutItems.get(l).getLabel(), layoutItems.get(l).getEditableForNew(), 
								layoutItems.get(l).getEditableForUpdate(), layoutItems.get(l).getPlaceholder(), 
								layoutItems.get(l).getRequired(), collapsedSection, collapse, null, null);

						List<LayoutComponent>  layoutComponents = layoutItems.get(l).getLayoutComponents();
						for(int m=0; m<layoutComponents.size();m++)
						{
							Details details = layoutComponents.get(m).getDetails();
							df.setDetails(layoutComponents.get(m).getDetails());
							List<Component> components= layoutComponents.get(m).getComponents();
							if(components.size() != 0)
							{
								for(int z=0; z<components.size();z++)
								{
									SFField df2 = new SFField();
									df2.setFieldsData(fieldset,
											components.get(z).getDetails().getLabel(),layoutItems.get(l).getEditableForNew(),
											layoutItems.get(l).getEditableForUpdate(),layoutItems.get(l).getPlaceholder(),
											layoutItems.get(l).getRequired(),collapsedSection,collapse,true,components.get(z).getDetails());

									detail_fields.put(df2.getLabel(), df2);
								}
							}
							else{	detail_fields.put(df.getLabel(), df);}
						}
					}	
				}	
			}
		}
	}
	

	public ForceObject getObject(String field)
	{
		SFField f;
		String type="default_case";
		if((f=edit_fields.get(field))==null)
			f=detail_fields.get(field);
		if(f != null)
			type =  f.getDetails().getType();
		else {
			f = new SFField(); f.setLabel(field);
		}
		
		ForceObject o = null;
		switch(type)
		{
		case "phone" : o = new PhoneInput(f, driver); break;
		case "email" : o = new EmailInput(f, driver); break;
		case "url" : o = new UrlInput(f, driver); break;
		case "_int" : o = new IntInput(f, driver); break;
		case "int" : o = new IntInput(f, driver); break;
		case "_double" : o = new DoubleInput(f, driver); break;
		case "double" : o = new DoubleInput(f, driver); break;
		case "string" :  o = new StringInput(f, driver); break;
		case "currency" : o = new CurrencyInput(f, driver); break;
		case "reference" : o = new ReferenceInput(f, driver); break;
		case "date" : o = new DateInput(f, driver); break;
		case "textarea" : o = new TextArea(f, driver); break;
		case "picklist" : o = new Select(f,driver); break;
		case "boolean" : o = new CheckBox(f, driver); break;
		case "datetime" : o = new DateTime(f, driver); break;
		default : o = new DefaultCase(f, driver);
		//Dont remove for debugging
		//System.out.println("[Error]-------------------------Matching Data Type not found for " + f.getLabel()+" : " +f.getDetails().getType() + "----------------------------");
		}
		return o;
	}
	
	//For Debugging
	 private static void print_map(Map<String,SFField> map)
	    {
	    	Iterator<Entry<String, SFField>> itr = map.entrySet().iterator();
	    	System.out.print("\n\n");
	    	while(itr.hasNext())
	    	{
	    		Entry<String, SFField> entry = itr.next();
	    		System.out.println(entry.getKey() + " : " + entry.getValue().getLabel() + ":" +entry.getValue().getDetails().getType());
	    	}
	    	System.out.print("\n\n");
	    } 
}
