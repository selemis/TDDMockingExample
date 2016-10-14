package simplejava;

public class NoPrintReportAuthorizationLoginServiceStub implements LoginService {
    @Override
    public String login(String user, String password) {
        return "success-login";
    }

    @Override
    public boolean hasAuthentication(String token, String action) {
        return false;
    }
}
