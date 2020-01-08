package sft;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sft.SFObject.GetSFObject;
import sft.SFObject.describeLayoutPOJO.Component__1;
import sft.SFObject.describeLayoutPOJO.Details;
import sft.SFObject.describeLayoutPOJO.Details__1;
import sft.SFObject.describeLayoutPOJO.Details__2;
import sft.SFObject.describeLayoutPOJO.Details__3;
import sft.SFObject.describeLayoutPOJO.EditLayoutSection;
import sft.SFObject.describeLayoutPOJO.Layout;
import sft.SFObject.describeLayoutPOJO.LayoutComponent__1;
import sft.SFObject.describeLayoutPOJO.LayoutItem__1;
import sft.SFObject.describeLayoutPOJO.LayoutRow__1;
import sft.SFObject.describeLayoutPOJO.SFVFDescription;

public final class GetFields {

	private static Map<String,SFField>  fields = new HashMap<String, SFField>();
	
	public static Map<String,SFField> get(String obj)
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
											df.inFieldSet = fieldset;
											df.label = layoutItems.get(l).getLabel();
											df.editableForNew = layoutItems.get(l).getEditableForNew();
											df.editableForUpdate = layoutItems.get(l).getEditableForUpdate();
											df.placeholder = layoutItems.get(l).getPlaceholder();
											df.required = layoutItems.get(l).getRequired();
											df.isInuseCollapsibleSection = collapsedSection;
											df.isInCollapsed = collapse;
												
						List<LayoutComponent__1>  layoutComponents = layoutItems.get(l).getLayoutComponents();
						for(int m=0; m<layoutComponents.size();m++)
						{
							
								Details details = layoutComponents.get(m).getDetails();
								
											df.details = layoutComponents.get(m).getDetails();
								
								
								List<Component__1> components= layoutComponents.get(m).getComponents();
								
								if(components.size() != 0)
								{
									for(int z=0; z<components.size();z++)
									{
										
										SFField df2 = new SFField();
										df2.inFieldSet = fieldset;
										df2.label = components.get(z).getDetails().getLabel();
										df2.editableForNew = layoutItems.get(l).getEditableForNew();
										df2.editableForUpdate = layoutItems.get(l).getEditableForUpdate();
										df2.placeholder = layoutItems.get(l).getPlaceholder();
										df2.required = layoutItems.get(l).getRequired();
										df2.isInuseCollapsibleSection = collapsedSection;
										df2.isInCollapsed = collapse;
										df2.details = components.get(z).getDetails();
										df2.isCompound = true;
										fields.put(df2.label, df2);
									}//z
								}
								else{	fields.put(df.label, df);}
						}
					}	
				}	
			}
		}
		
		
		
		
    	return fields;
	} //get
	

	public static void main(String[] args)
	{
		Map<String,SFField> lead = GetFields.get("Account");
		Iterator<Map.Entry<String, SFField>> itr = fields.entrySet().iterator();
    	
    	while(itr.hasNext())
    	{
    		Map.Entry<String, SFField> entry = itr.next();
    		SFField field = entry.getValue();
    		
    		System.out.println(field.label);
    		System.out.println("\t inFieldSet:" + field.inFieldSet);
    		System.out.println("\t required:" + field.required);
    		System.out.println("\t placeholder:" + field.placeholder);
    		System.out.println("\t isInuseCollapsibleSection:" + field.isInuseCollapsibleSection);
    		System.out.println("\t isInCollapsed:" + field.isInCollapsed);
    		System.out.println("\t isCompound:" + field.isCompound);
    		System.out.println("\t editableForUpdate:" + field.editableForUpdate);
    		System.out.println("\t editableForNew:" + field.editableForNew);
    		System.out.println("\t type:" + field.details.getType()); 
    	}
	}

}


class SFField
{	
	public String label=null;
	public Boolean isCompound=false;
	public String inFieldSet=null;
	public Boolean isInCollapsed=false;
	public Boolean isInuseCollapsibleSection=false;
	public Boolean editableForNew=false;
	public Boolean editableForUpdate=false;
	public Boolean placeholder=false;
	public Boolean required=false;
	public Details details=null;
}