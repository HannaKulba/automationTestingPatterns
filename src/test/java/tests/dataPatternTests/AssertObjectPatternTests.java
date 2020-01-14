package tests.dataPatternTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import patterns.data.AssertObject.UserAssert;
import utils.User;

import java.util.List;

public class AssertObjectPatternTests {
    private UserAssert userAssert;

    @BeforeTest
    public void testSetUp_ao() {
        userAssert = new UserAssert(User.getAllUsers());
    }

    @Test()
    public void checkCountry() {
        List<User> belarusUsers = userAssert.searchUsersWithCertainCountry("Belarus");
        userAssert.assertThat(belarusUsers).hasSingleUserInCountry("Belarus");
    }
}
