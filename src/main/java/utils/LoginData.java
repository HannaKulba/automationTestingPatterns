package utils;

import java.util.Map;
import java.util.TreeMap;

public class LoginData {
    public static Map<String, String> dataMap = createDataMap();

    private static Map<String, String> createDataMap() {
        Map<String, String> result = new TreeMap<>();
        result.put("taxID", "546383");
        result.put("firstName", "John");
        result.put("lastName", "Newman");
        result.put("address1", "Y.Kupaly street, 5");
        result.put("postcode", "230067");
        result.put("city", "Grodno");
        result.put("country", "Belarus");
        result.put("email", "john_newman1905@gmail.com");
        result.put("phone", "+375334445567");
        result.put("password", "JohnNewman2019");
        return result;
    }
}
