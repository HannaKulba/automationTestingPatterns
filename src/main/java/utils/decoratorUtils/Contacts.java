package utils.decoratorUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import utils.User;

public class Contacts extends Decorator {
    private static final Logger LOG = Logger.getLogger(Contacts.class);

    private RegisterUser user;

    public Contacts(RegisterUser user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getUserInfo() {
        String username = getUsername();
        User us = User.getUser(username);
        if (us != null) {
            LOG.log(Level.INFO, "e-mail: " + us.getEmail() + "\nmobile: " + us.getPhone());
            return user.getUserInfo() + "e-mail: " + us.getEmail() + "\nmobile: " + us.getPhone() + "\n";
        } else {
            LOG.log(Level.ERROR, "Unable to get user contacts. User with username " + getUsername() + " doesn't exist.");
            return "Unable to get user contacts. User with username " + getUsername() + " doesn't exist.\n";
        }
    }
}
