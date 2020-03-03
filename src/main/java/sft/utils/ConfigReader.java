package sft.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {
    String config_file;


    public ConfigReader(String config_file){
        this.config_file = config_file;
    }

    public Map<String, String> getSetupDetails() {
        Map<String, String> setup = new HashMap<String,String>();
        try {
            setup = new ObjectMapper().readValue(new File(config_file), new TypeReference<Map<String, String>>() {
            });
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return setup;
    }

    //Testing
    public static void main(final String[] args) {
//        System.out.println(SftSetup.generate_token());
//        System.out.println(System.getProperty("AccessToken"));
//        final String setup_file = "./autoSetup.json";
        final  String setup_file = System.getProperty("user.dir") + File.separator + "autoSetup.json";

        ConfigReader test = new ConfigReader(setup_file);
        System.out.println(test.getSetupDetails().get("username"));
    }

}
