package utils.decoratorUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Petr extends RegisterUser {
    private static final Logger LOG = Logger.getLogger(Petr.class);
    private String userName = "Petr Petrov";

    public String getUsername() {
        return userName;
    }

    public String getUserInfo() {
        LOG.log(Level.INFO, userName);
        return userName + "\n";
    }
}
