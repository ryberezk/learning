package my.project.pack;

public class UserData {
    private String username = "student";
    private String password = "luxoft";

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserData() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
