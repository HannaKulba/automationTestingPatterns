package utils.decoratorUtils;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Julia extends RegisterUser {
    private static final Logger LOG = Logger.getLogger(Julia.class);
    private String userName = "Julia Sidorova";

    public String getUsername() {
        return userName;
    }

    public String getUserInfo() {
        LOG.log(Level.INFO, userName);
        return userName + "\n";
    }
}
