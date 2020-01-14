package utils;


public class Account {

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

    public static class Builder {
        private Account newAccount;

        public Builder() {
            newAccount = new Account();
        }

        public Builder withTaxID(String taxID) {
            newAccount.taxID = taxID;
            return this;
        }

        public Builder withFirstName(String firstName) {
            newAccount.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            newAccount.lastName = lastName;
            return this;
        }

        public Builder withAddress1(String address1) {
            newAccount.address1 = address1;
            return this;
        }

        public Builder withPostCode(String postcode) {
            newAccount.postcode = postcode;
            return this;
        }

        public Builder withCity(String city) {
            newAccount.city = city;
            return this;
        }

        public Builder withCountry(String country) {
            newAccount.country = country;
            return this;
        }

        public Builder withEmail(String email) {
            newAccount.email = email;
            return this;
        }

        public Builder withPhone(String phone) {
            newAccount.phone = phone;
            return this;
        }

        public Builder withPassword(String password) {
            newAccount.password = password;
            return this;
        }

        public Account build() {
            return newAccount;
        }
    }
}
