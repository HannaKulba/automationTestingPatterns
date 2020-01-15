package tests.technicalPatternTests;

import org.testng.annotations.Test;
import utils.decoratorUtils.*;

public class DecoratorPatternTests {

    @Test
    public void test_1() {
        RegisterUser userJulia = new Julia();
//        System.out.print(userJulia.getUserInfo());
//        userJulia = new Address(userJulia);
//        System.out.print(userJulia.getUserInfo());
//        userJulia = new Contacts(userJulia);
//        System.out.print(userJulia.getUserInfo());

        RegisterUser userJulia2 = new Address(new Contacts(userJulia));
        System.out.print(userJulia2.getUserInfo());


    }

    @Test
    public void test_2() {
        RegisterUser userTomasz = new Tomasz();
        RegisterUser userTomasz2 = new Address(new Contacts(userTomasz));
        System.out.print(userTomasz2.getUserInfo());


    }



}
