package tests.technicalPatternTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.decoratorUtils.*;

public class DecoratorPatternTests {
    private RegisterUser userJulia;
    private RegisterUser userTomasz;
    private RegisterUser userPetr;

    @BeforeTest
    public void setUp() {
        userJulia = new Julia();
        userTomasz = new Tomasz();
        userPetr = new Petr();
    }

    @Test
    public void testUserInfo_Julia() {
        RegisterUser userJulia2 = new Address(new Contacts(userJulia));
        System.out.print(userJulia2.getUserInfo());
    }

    @Test
    public void testUserInfo_Tomasz() {
        RegisterUser userTomasz2 = new Address(new Contacts(userTomasz));
        System.out.print(userTomasz2.getUserInfo());
    }

    @Test
    public void testUserInfo_Petr() {
        RegisterUser userPetr2 = new Address(new Contacts(userPetr));
        System.out.print(userPetr2.getUserInfo());
    }

}
