package utils.proxyUtils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import utils.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserUtilImpl implements UserUtil {
    private String pathToCSV = "./src/main/resources/Data_CreateAccounts.csv";
    private String[] userData;
    private String username;

    public UserUtilImpl(String[] userData){
        this.userData = userData;
        username = userData[1] + " " + userData[2];
    }

    public User createUser() {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(pathToCSV, true));
            writer.writeNext(userData);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = userData[1] + " " + userData[2];
        return User.getUser(username);
    }

    public void deleteUser() {
        String firstName = username.split(" ")[0];
        String lastName = username.split(" ")[1];
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV), ',', '"', 0);
            List<String[]> rows = reader.readAll();
            int index = rows.size();
            for (int i = 0; i < rows.size(); i++) {
                if (rows.get(i)[1].equals(firstName) && rows.get(i)[2].equals(lastName)) {
                    index = i;
                }
            }
            if (index != rows.size()) {
                rows.remove(index);
                FileWriter sw = new FileWriter(pathToCSV);
                CSVWriter writer = new CSVWriter(sw);
                writer.writeAll(rows);
                writer.close();
                System.out.println("=== User " + username + " was deleted! ===");
            } else {
                System.out.println("=== No data in the file with user " + username + "! ===");
            }
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
