package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReaderForProfileMandatoryFIelds {
    public String Fn,Ln,job,institution,country;

    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/profileData.json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;
            Fn = (String) person.get("firstName");
            Ln = (String) person.get("lastName1");
            job= (String) person.get("jobTitle");
            institution = (String) person.get("institution");
            country = (String) person.get("country");

        }
    }

}
