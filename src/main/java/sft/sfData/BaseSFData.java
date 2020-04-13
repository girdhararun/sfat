package sft.sfData;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

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
}
