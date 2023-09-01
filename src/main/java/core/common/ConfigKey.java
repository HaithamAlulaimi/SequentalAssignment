package core.common;

public enum ConfigKey {

    BASE_URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    private final String key;
    ConfigKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
}
