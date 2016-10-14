package simplejava;

public class ReportPrinter {

    private LoginService loginService;
    private String token;

    public ReportPrinter() {
        loginService = new RealLoginService();
    }

    public void start(String userId, String password) {
        token = loginService.login(userId, password);
        if (token == null)
            throw new RuntimeException("You are not logged in");
    }

    public String printReport() {
        if (loginService.hasAuthentication(token, "printReport"))
            return "This is a huge report";
        else
            throw new RuntimeException("You are not allowed to use the print print report");
    }


}
