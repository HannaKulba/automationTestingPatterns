package utils;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class User {
    private String pathToCSV = "./src/main/resources/Data_CreateAccounts.csv";
    private List<String[]> rows;
    private int userNumber;

    public User (int userNumber) {
        this.userNumber = userNumber;
    }

    private List<String[]> getDataFromFile() {
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV), ',', '"', 1);
            rows = reader.readAll();
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return rows;
    }

    public String getTaxID() {
        return getDataFromFile().get(userNumber)[0];
    }

    public String getFirstName() {
        return getDataFromFile().get(userNumber)[1];
    }

    public String getLastName() {
        return getDataFromFile().get(userNumber)[2];
    }

    public String getAddress1() {
        return getDataFromFile().get(userNumber)[3];
    }

    public String getPostCode() {
        return getDataFromFile().get(userNumber)[4];
    }

    public String getCity() {
        return getDataFromFile().get(userNumber)[5];
    }

    public String getCountry() {
        return getDataFromFile().get(userNumber)[6];
    }

    public String getEmail() {
        return getDataFromFile().get(userNumber)[7];
    }

    public String getPhone() {
        return getDataFromFile().get(userNumber)[8];
    }

    public String getPassword() {
        return getDataFromFile().get(userNumber)[9];
    }


}
