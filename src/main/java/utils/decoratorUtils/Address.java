package utils.decoratorUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import utils.User;

public class Address extends Decorator {
    private static final Logger LOG = Logger.getLogger(Address.class);
    private RegisterUser user;

    public Address(RegisterUser user) {
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getUserInfo() {
        User us = User.getUser(getUsername());
        if (us != null) {
            LOG.log(Level.INFO,"address: " + us.getPostCode() + ", " + us.getCountry() + ", " + us.getCity() + ", " + us.getAddress1());
            return user.getUserInfo() + "address: " + us.getPostCode() + ", " + us.getCountry() + ", " + us.getCity() + ", " + us.getAddress1() + "\n";
        } else {
            LOG.log(Level.ERROR, "Unable to get user address. User with username " + getUsername() + " doesn't exist.");
            return "Unable to get user address. User with username " + getUsername() + " doesn't exist.\n";
        }
    }
}
