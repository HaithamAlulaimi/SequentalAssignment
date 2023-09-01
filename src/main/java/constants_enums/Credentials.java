package constants_enums;

public enum Credentials {

    Valid_UserName("Admin"),
    Valid_Password("admin123"),
    Invalid_UserName("Haitham"),
    Invalid_Password("Test@12345");
    private final String key;

    Credentials(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}
