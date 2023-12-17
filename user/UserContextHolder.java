package user;

public class UserContextHolder {

    private String username;
    private String password;

    private UserContextHolder() {
    }

    private static class UserContextHolderHelper {
        private static final UserContextHolder CONTEXT_HOLDER_INSTANCE = new UserContextHolder();
    }

    public static UserContextHolder getInstance() {
        return UserContextHolderHelper.CONTEXT_HOLDER_INSTANCE;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
