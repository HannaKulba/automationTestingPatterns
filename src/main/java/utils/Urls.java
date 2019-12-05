package utils;

public enum Urls {
    createAccountURL("http://litecart.stqa.ru/ru/create_account"),
    editAccountURL("http://litecart.stqa.ru/ru/edit_account"),
    HTMLTableURL("https://www.w3schools.com/html/html_tables.asp");

    private String URL;

    Urls(String URL) {
        this.URL = URL;
    }

    public String getURL(){
        return URL;
    }
}

