package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReaderForProfile {
    public String FirstN,InvalidFN,ShortFN,LongFN,spacesFN,LastN,InvalidLN,ShortLN,LongLN,spacesLN,
            job,institution,birthOfDate,gender,country,city,invalidCity,governorate,invalidGovernorate,nationality,
            invalidNationality,postal,invalidPostal,address,invalidAddress;

    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/profileData.json";

        File srcFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

        for (Object jsonObj : jarray) {
            JSONObject person = (JSONObject) jsonObj;
            FirstN = (String) person.get("firstName");
            LastN = (String) person.get("lastName1");
            job= (String) person.get("jobTitle");
            institution = (String) person.get("institution");
            birthOfDate = (String) person.get("birth");
            gender = (String) person.get("gender");
            country = (String) person.get("country");
            city = (String) person.get("city");
            invalidCity=(String) person.get("invalidCity");
            governorate = (String) person.get("governorate");
            invalidGovernorate = (String) person.get("invalidGovernorate");
            nationality = (String) person.get("nationality");
            invalidNationality = (String) person.get("invalidNationality");
            postal = (String) person.get("postalCode");
            InvalidFN = (String) person.get("invalidFirstName");
            ShortFN = (String) person.get("TooShortFirstName");
            LongFN = (String) person.get("TooLongFirstName");
            spacesFN = (String) person.get("FirstNameSpaces");
            InvalidLN= (String) person.get("invalidLastName");
            ShortLN = (String) person.get("TooShortLastName");
            LongLN = (String) person.get("TooLongLastName");
            spacesLN = (String) person.get("LastNameSpaces");
            invalidPostal = (String) person.get("invalidPostalCode");
            address = (String) person.get("Address");
            invalidAddress = (String) person.get("invalidAddress");

        }
    }


}
