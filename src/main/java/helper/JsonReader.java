package helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static JSONObject readJsonFile(String filePath) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader
                    ("src\\main\\java\\payloads\\petsStore\\" + filePath));
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getJsonValue(JSONObject jsonObject, String jsonPath) {
        try {
            Object value = jsonObject.get(jsonPath);
            return value != null ? value.toString() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
