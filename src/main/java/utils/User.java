package utils;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String taxID;
    private String firstName;
    private String lastName;
    private String address1;
    private String postcode;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String password;

    public String getTaxID() {
        return taxID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getPostCode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    private void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setAddress1(String address1) {
        this.address1 = address1;
    }

    private void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setCountry(String country) {
        this.country = country;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private static List<String[]> getAllUsersData() {
        String pathToCSV = "./src/main/resources/Data_CreateAccounts.csv";
        List<String[]> rows = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV), ',', '"', 1);
            rows = reader.readAll();
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return rows;
    }

    public static User getUser(int userNumber) {
        String[] result = getAllUsersData().get(userNumber);
        User user = new User();
        user.setTaxID(result[0]);
        user.setFirstName(result[1]);
        user.setLastName(result[2]);
        user.setAddress1(result[3]);
        user.setPostcode(result[4]);
        user.setCity(result[5]);
        user.setCountry(result[6]);
        user.setEmail(result[7]);
        user.setPhone(result[8]);
        user.setPassword(result[9]);
        return user;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        int size = getAllUsersData().size();
        for (int i = 0; i < size; i++) {
            users.add(getUser(i));
        }
        return users;
    }

}
