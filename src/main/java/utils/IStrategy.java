package utils;

import java.util.Map;

public interface IStrategy {
    Map createAccount(Map<String, String> loginData);
}
