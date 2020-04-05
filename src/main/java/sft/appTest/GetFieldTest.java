package sft.appTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sft.forceObject.Input.Input;
import sft.forceObject.objField;
import sft.sfData.objectDescribe.GetFields;

import java.util.Map;

public class GetFieldTest {
    WebDriver d;

    @Before
    public void setUp(){
        d = new ChromeDriver();
    }

    @Test
    public void checkForceObjectCreation(){
        GetFields getfields = new GetFields("lead",d);
        Map<String, objField> editFiledsChk = getfields.getEditFields();
        Assert.assertEquals(getfields.getObject("Country") instanceof Input, true);
    }

    @AfterClass
    public void cleanup(){
        d.quit();

    }
}
