package simplejava;

import org.junit.Test;

import static org.junit.Assert.*;


public class ReportPrinterTest {

    @Test
    public void good_login_with_fake() {
        LoginService fakeLoginService = new FakeLoginService();
        ReportPrinter printer = new ReportPrinter(fakeLoginService);
        printer.start("userId", "password");
        assertEquals("This is a huge report", printer.printReport());
    }

    @Test (expected = FailedLoginException.class)
    public void bad_login_with_fake() {
        LoginService fakeLoginService = new FakeLoginService();
        ReportPrinter printer = new ReportPrinter(fakeLoginService);
        printer.start("userId", "pass");
    }

    @Test (expected = NoPrintReportAuthorizationException.class)
    public void user_has_logged_in_but_has_no_authority_to_print_report() {
        LoginService loginServiceStub = new NoPrintReportAuthorizationLoginServiceStub();
        ReportPrinter printer = new ReportPrinter(loginServiceStub);
        printer.start("userId", "password");
        printer.printReport();
    }

    @Test
    public void user_can_print_the_report_using_a_spy() {
        LoginServiceSpy loginServiceSpy = new LoginServiceSpy();
        ReportPrinter printer = new ReportPrinter(loginServiceSpy);
        printer.start("userId", "password");
        assertEquals("This is a huge report", printer.printReport());
        assertEquals("userId", loginServiceSpy.userId);
        assertEquals("password", loginServiceSpy.password);
        assertEquals("printReport", loginServiceSpy.action);
        assertEquals("success-token", loginServiceSpy.token);
    }

}