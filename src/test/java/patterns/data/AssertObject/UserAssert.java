package patterns.data.AssertObject;


import org.testng.Assert;
import utils.User;

import java.util.List;

public class UserAssert {
    private List<User> users;

    public UserAssert(List<User> users) {
        this.users = users;
    }

    public List<User> searchUsersWithCertainCountry(String country) {
        List<User> result = User.getAllUsers();
        for (User user : result) {
            if (user.getCountry().equals(country))
                users.add(user);
        }
        return users;
    }

    public UserAssert assertThat(List<User> users) {
        return new UserAssert(users);
    }

    public void hasSingleUserInCountry(String country) {
        if (users.size() == 1) {
            String actualCountry = users.get(0).getCountry();
            Assert.assertEquals(actualCountry, country, "Actual value is not like expected.");
        }
    }

}
