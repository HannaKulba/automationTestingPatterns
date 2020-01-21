package utils.proxyUtils;

import utils.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserUtilProxy implements UserUtil {
    private UserUtil userUtil;
    private static final List<String> restrictUsersList;
    private String[] userData;
    private String username;

    //restrict access for the below users
    static {
        restrictUsersList = new ArrayList<>();
        restrictUsersList.add("Donald Tramp");
        restrictUsersList.add("Angela Merkel");
    }

    public UserUtilProxy(String[] userData) {
        this.userData = userData;
        username = userData[1] + " " + userData[2];
        if (!restrictUsersList.contains(username)) {
            userUtil = new UserUtilImpl(userData);
        } else {
            System.out.println("Unable to create user " + username + ". This user is in the restrict list!");
        }
    }

    public User createUser() {
        if (Objects.nonNull(userUtil)) {
            return userUtil.createUser();
        }
        return null;
    }

    public void deleteUser() {
        if (Objects.nonNull(userUtil)) {
            userUtil.deleteUser();
        }
    }
}
