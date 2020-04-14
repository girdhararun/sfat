package sft.sfData;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sft.forceObject.Checkbox.CheckBox;
import sft.forceObject.DateTime.DateTime;
import sft.forceObject.DefaultCase.DefaultCase;
import sft.forceObject.ForceObject;
import sft.forceObject.Input.*;
import sft.forceObject.Select.Select;
import sft.forceObject.TextArea.TextArea;
import sft.forceObject.objField;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class BaseSFData {
    WebDriver driver;
    public BaseSFData(){}
    public BaseSFData(WebDriver d){
        driver = d;
    }

    //map JSON string to POJO
    public <T> T getDescriptionInstance(String description, Class<T> mapClass){
        T t = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            t = mapper.readValue(description, mapClass);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
    public ForceObject getType(objField f,String type) {
        ForceObject o = null;
        switch (type) {
            case "phone":
                o = new PhoneInput(f, driver);
                break;
            case "email":
                o = new EmailInput(f, driver);
                break;
            case "url":
                o = new UrlInput(f, driver);
                break;
            case "_int":
                o = new IntInput(f, driver);
                break;
            case "int":
                o = new IntInput(f, driver);
                break;
            case "_double":
                o = new DoubleInput(f, driver);
                break;
            case "double":
                o = new DoubleInput(f, driver);
                break;
            case "string":
                o = new StringInput(f, driver);
                break;
            case "currency":
                o = new CurrencyInput(f, driver);
                break;
            case "reference":
                o = new ReferenceInput(f, driver);
                break;
            case "date":
                o = new DateInput(f, driver);
                break;
            case "textarea":
                o = new TextArea(f, driver);
                break;
            case "picklist":
                o = new Select(f, driver);
                break;
            case "boolean":
                o = new CheckBox(f, driver);
                break;
            case "datetime":
                o = new DateTime(f, driver);
                break;
            default:
                o = new DefaultCase(f, driver);
                //Dont remove for debugging
                //System.out.println("[Error]-------------------------Matching Data Type not found for " + f.getLabel()+" : " +f.getDetails().getType() + "----------------------------");
        }
        return o;
    }
    //For Debugging
    public void print_map(Map<String, objField> map) {
        Iterator<Map.Entry<String, objField>> itr = map.entrySet().iterator();
        System.out.print("\n\n");
        while (itr.hasNext()) {
            Map.Entry<String, objField> entry = itr.next();
            System.out.println(entry.getKey() + " : " + entry.getValue().getLabel() + ":" + entry.getValue().getDetails().getType() + " : "+entry.getValue().getRequired());
        }
        System.out.print("\n\n");
    }
}
