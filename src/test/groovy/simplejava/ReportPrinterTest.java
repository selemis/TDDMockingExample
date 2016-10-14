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

    @Test (expected = RuntimeException.class)
    public void bad_login_with_fake() {
        LoginService fakeLoginService = new FakeLoginService();
        ReportPrinter printer = new ReportPrinter(fakeLoginService);
        printer.start("userId", "pass");
    }

}