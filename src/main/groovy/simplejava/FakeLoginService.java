package simplejava;

public class FakeLoginService implements LoginService {

    @Override
    public String login(String user, String password) {
        if ("password".equals(password))
            return "success-token";
        else
            return null;
    }

    @Override
    public boolean hasAuthentication(String token, String action) {
        if ("success-token".equals(token) && "printReport".equals(action))
            return true;

        return false;
    }
}
