package pojo;

public class Users {
    private int username;
    private int password;

    @Override
    public String toString() {
        return "Users{" +
                "username=" + username +
                ", password=" + password +
                '}';
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Users(int username, int password) {
        this.username = username;
        this.password = password;
    }

    public Users() {
    }
}
