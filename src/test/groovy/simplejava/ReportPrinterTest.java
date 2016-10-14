package simplejava;

import org.junit.Test;

import static org.junit.Assert.*;


public class ReportPrinterTest {

    @Test
    public void good_login() {
        ReportPrinter printer = new ReportPrinter();
        printer.start("userId", "password");
        assertEquals("This is a huge report", printer.printReport());
    }

}