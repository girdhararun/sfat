package sft.appTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sft.forceObject.Input.Input;
import sft.forceObject.SFField;
import sft.GetFields;

import java.util.Map;

public class GetFieldTest {
    WebDriver d = new ChromeDriver();
    GetFields getfields = new GetFields("lead",d);
    Map<String, SFField> editFiledsChk = getfields.getEditFields();

    @Test
    public void checkForceObjectCreation(){
        Assert.assertEquals(getfields.getObject("Country") instanceof Input, true);
        d.quit();
    }
}
