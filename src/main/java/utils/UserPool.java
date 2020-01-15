package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserPool {

    private static final Map<User, Boolean> USER_POOL = createUserPool();

    private static Map<User, Boolean> createUserPool() {
        Map<User, Boolean> result = new HashMap<>();
        List<User> users = User.getAllUsers();

        for (User user : users) {
            result.put(user, true);
        }

        return result;
    }

    public static User getAvailableUser(String userFirstName, String userLastName) {
        User user;

        for (Map.Entry<User, Boolean> entry : USER_POOL.entrySet()) {
            if (entry.getKey().getFirstName().equals(userFirstName) && entry.getKey().getLastName().equals(userLastName)) {
                user = entry.getKey();
                entry.setValue(false);
                System.out.println("User " + userFirstName + " " + userLastName + " was found!");
                return user;
            }
        }
        System.out.println("User " + userFirstName + " " + userLastName + " WAS NOT FOUND!");
        return null;
    }

    public static void returnUserToPool(String userEmail) {
        for (Map.Entry<User, Boolean> entry : USER_POOL.entrySet()) {
            if (entry.getKey().getEmail().equals(userEmail)) {
                entry.setValue(true);
                return;
            }
        }
    }
}
