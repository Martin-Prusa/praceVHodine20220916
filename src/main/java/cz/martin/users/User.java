package cz.martin.users;

public class User {
    private String username;
    private String password;
    private int userId;
    private int groupId;
    private String gecos;
    private String homeDirectory;
    private String loginShell;

    public User(String username, String password, int userId, int groupId, String gecos, String homeDirectory, String loginShell) {
        this.username = username;
        this.password = password;
        this.userId = userId;
        this.groupId = groupId;
        this.gecos = gecos;
        this.homeDirectory = homeDirectory;
        this.loginShell = loginShell;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getGecos() {
        return gecos;
    }

    public String getHomeDirectory() {
        return homeDirectory;
    }

    public String getLoginShell() {
        return loginShell;
    }
}
