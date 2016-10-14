package simplejava;

public class RealLoginService implements LoginService {

    @Override
    public String login(String user, String password) {
        //This is supposed to be a real implementation
        return null;
    }

    @Override
    public boolean hasAuthentication(String token, String action) {
        //This is supposed to be a real implementation
        return false;
    }

}
