package simplejava;

public class LoginServiceSpy implements LoginService {

    public String userId;
    public String password;
    public String token;
    public String action;

    @Override
    public String login(String user, String password) {
        this.userId = user;
        this.password = password;
        return "success-token";
    }

    @Override
    public boolean hasAuthentication(String token, String action) {
        this.token = token;
        this.action = action;
        return true;
    }
}
