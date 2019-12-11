package patterns.structure.Strategy;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import utils.IStrategy;
import utils.Locator;
import utils.Urls;

import java.util.Map;

public class CreatePageRestStrategy implements IStrategy {

    @Override
    public Map createAccount(Map<String, String> loginData) {
        Response resp = RestAssured.given().contentType("application/x-www-form-urlencoded")
                .formParam("token", "76041ff91fe191e2983366a4fe917fd7db345b39")
                .formParam("tax_id", loginData.get("taxID"))
                .formParam("company", "")
                .formParam("firstname", loginData.get("firstName"))
                .formParam("lastname", loginData.get("lastName"))
                .formParam("address1", loginData.get("address1"))
                .formParam("address2", "")
                .formParam("postcode", loginData.get("postcode"))
                .formParam("city", loginData.get("city"))
                .formParam("country_code", "BY")
                .formParam("zone_code", "")
                .formParam("email", loginData.get("email") + (int) (Math.random() * 1000))
                .formParam("phone", loginData.get("phone"))
                .formParam("newsletter", "1")
                .formParam("password", loginData.get("password"))
                .formParam("confirmed_password", loginData.get("password"))
                .formParam("create_account", "Create Account")
                .post(Urls.createAccountURL.getURL());
        return resp.cookies();
    }

    public String getValue(Map<String, String> cookies, String locator) {
        Response resp = RestAssured.given().cookies(cookies).get(Urls.editAccountURL.getURL());
        //System.out.println(resp.getBody().htmlPath().get("**.find {it.@name == '" + locator + "'}.@value"));
        return resp.getBody().htmlPath().get("**.find {it.@name == '" + locator + "'}.@value");
    }
}
