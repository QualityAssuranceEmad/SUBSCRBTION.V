package data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReaderForSignUp {
    public String firstName, lastName,email,mobile,password,confirmPass;

    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/userData.json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;

            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            mobile = (String) person.get("phone");
            email = (String) person.get("email");
            password = (String) person.get("pass1");
            confirmPass = (String) person.get("pass2");
        }


}


}