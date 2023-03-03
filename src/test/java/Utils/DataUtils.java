package Utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataUtils {
    @DataProvider
    public static Object[][] cartDataProvider() {
        return readJson(ConstantUtils.CART_FILE, "add to cart");
    }
    @DataProvider
    public static Object[][] checkCartDp() {
        return readJson(ConstantUtils.CART_FILE, "check cart");
    }

    @DataProvider
    public static Object[][] accountTestDp() {
        return readJson(ConstantUtils.MY_ACCOUNT_FILE, "my account");
    }

    @DataProvider
    public static Object[][] emailRegistrationDp() {
        return readJson(ConstantUtils.MY_ACCOUNT_FILE, "email registration");
    }

    public static Object[][] readJson(String filename, String jsonObj) {
        File file = new File(filename);
        JsonElement jsonElement = null;

        // Parse JSON data
        try {
            jsonElement = JsonParser.parseReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert jsonElement != null;
        // Get entire JSON object
        JsonObject jsonObj1 = jsonElement.getAsJsonObject();
        // Get individual JSON array object
        JsonArray jsonArray = jsonObj1.get(jsonObj).getAsJsonArray();

        // Java array to store JSON data
        Object[][] testData = new Object[jsonArray.size()][1];

        // Read data inside JSON array and store it in Java array
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObj2 = jsonArray.get(i).getAsJsonObject();
            Map<Object, Object> map = new HashMap<>();

            for (String key : jsonObj2.keySet()) {
                String value = jsonObj2.get(key).getAsString();
                map.put(key, value);
            }
            testData[i][0] = map;
        }
        return testData;
    }
}
