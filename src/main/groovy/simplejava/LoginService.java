package simplejava;


public interface LoginService {

    String login(String user, String password);

    boolean hasAuthentication(String token, String action);

}
