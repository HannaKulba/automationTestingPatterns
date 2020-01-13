package utils;

import java.util.Map;
import java.util.TreeMap;

public class LoginData {
//    public static String taxID = "546383";
//    public static String firstName = "John";
//    public static String lastName = "Newman";
//    public static String address1 = "Y.Kupaly street, 5";
//    public static String postcode = "230067";
//    public static String city = "Grodno";
//    public static String country = "Belarus";
//    public static String email = "john_newman1905@gmail.com";
//    public static String phone = "+375334445567";
//    public static String pass = "JohnNewman2019";

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
