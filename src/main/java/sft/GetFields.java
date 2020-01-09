package sft;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import sft.ForceObject.ForceObject;
import sft.ForceObject.Input.CurrencyInput;
import sft.ForceObject.Input.DateInput;
import sft.ForceObject.Input.DoubleInput;
import sft.ForceObject.Input.EmailInput;
import sft.ForceObject.Input.IntInput;
import sft.ForceObject.Input.PhoneInput;
import sft.ForceObject.Input.ReferenceInput;
import sft.ForceObject.Input.StringInput;
import sft.ForceObject.Input.UrlInput;
import sft.ForceObject.Select.Select;
import sft.ForceObject.TextArea.TextArea;
import sft.SFObject.GetSFObject;
import sft.SFObject.describeLayoutPOJO.Component__1;
import sft.SFObject.describeLayoutPOJO.Details;
import sft.SFObject.describeLayoutPOJO.EditLayoutSection;
import sft.SFObject.describeLayoutPOJO.Layout;
import sft.SFObject.describeLayoutPOJO.LayoutComponent__1;
import sft.SFObject.describeLayoutPOJO.LayoutItem__1;
import sft.SFObject.describeLayoutPOJO.LayoutRow__1;
import sft.SFObject.describeLayoutPOJO.SFVFDescription;

public final class GetFields {

	private WebDriver driver;
	private  static Map<String,SFField>  fields = new HashMap<String, SFField>();
	public GetFields(String obj, WebDriver d)
	{
		generater(obj);
		driver = d;
	}

	public Map<String,SFField> get()
	{
		return fields;
	}

	private  void generater(String obj)
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

									fields.put(df2.getLabel(), df2);
								}
							}
							else{	fields.put(df.getLabel(), df);}
						}
					}	
				}	
			}
		}
	}


	public ForceObject getObject(String field)
	{
		SFField f = fields.get(field);
		final String type =  f.getDetails().getType();
		ForceObject o = null;
		switch(type)
		{
		case "phone" : o = new PhoneInput(f, driver); break;
		case "email" : o = new EmailInput(f, driver); break;
		case "url" : o = new UrlInput(f, driver); break;
		case "_int" : o = new IntInput(f, driver); break;
		case "_double" : o = new DoubleInput(f, driver); break;
		case "string" :  o = new StringInput(f, driver); break;
		case "currency" : o = new CurrencyInput(f, driver); break;
		case "reference" : o = new ReferenceInput(f, driver); break;
		case "date" : o = new DateInput(f, driver); break;
		case "textarea" : o = new TextArea(f, driver); break;
		case "picklist" : o = new Select(f,driver);
		}
		return o;
	}

}