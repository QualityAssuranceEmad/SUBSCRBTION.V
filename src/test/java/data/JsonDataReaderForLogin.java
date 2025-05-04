package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReaderForLogin {
    public String email,password;

    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/loginData.json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;
            email = (String) person.get("email");
            password = (String) person.get("password");
        }


    }
}
