package utils.decoratorUtils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Tomasz extends RegisterUser {
    private static final Logger LOG = Logger.getLogger(Tomasz.class);
    private String userName = "Tomasz Jackowski";

    public String getUsername() {
        return userName;
    }

    public String getUserInfo() {
        LOG.log(Level.INFO, userName);
        return userName + "\n";
    }

}
