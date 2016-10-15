package simplejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginServiceMock implements LoginService {

    private List<String> actions = new ArrayList<String>();

    @Override
    public String login(String user, String password) {
        actions.add("login: " + user + ", " + password);
        return "success-token";
    }

    @Override
    public boolean hasAuthentication(String token, String action) {
        actions.add("hasAuthentication: " + token + ", " + action);
        return true;
    }

    public boolean verify(String userId, String password) {
        final List<String> expectedActions = Arrays.asList(
                "login: " + userId + ", " + password,
                "hasAuthentication: success-token, printReport"
        );

        return actions.equals(expectedActions);
    }

}
