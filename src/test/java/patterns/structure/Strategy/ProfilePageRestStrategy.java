package patterns.structure.Strategy;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import utils.Urls;

import java.util.Map;

public class ProfilePageRestStrategy {

    public String getValue(Map<String, String> cookies, String locator) {
        Response resp = RestAssured.given().cookies(cookies).get(Urls.editAccountURL.getURL());
        return resp.getBody().htmlPath().get("**.find {it.@name == '" + locator + "'}.@value");
    }
}
