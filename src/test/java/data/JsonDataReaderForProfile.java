package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReaderForProfile {
    public String Fn,Ln,job,institution,birthOfDate,gender,country,city,governorate,nationality,postal;

    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/profileData.json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;
            Fn = (String) person.get("firstName");
            Ln = (String) person.get("Lastname");
            job= (String) person.get("jobTitle");
            institution = (String) person.get("institution");
            birthOfDate = (String) person.get("birth");
            gender = (String) person.get("gender");
            country = (String) person.get("country");
            city = (String) person.get("city");
            governorate = (String) person.get("governorate");
            nationality = (String) person.get("nationality");
            postal = (String) person.get("zipCode");
        }
    }


}
