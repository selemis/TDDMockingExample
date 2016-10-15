package spock

import simplejava.LoginService
import simplejava.ReportPrinter
import spock.lang.Specification

class ReportPrinterSpec extends Specification {

    def 'good login'() {
        given: 'the login service will succeed and the user has print report authority'
        LoginService successloginServiceStub = Stub(LoginService)
        successloginServiceStub.login( _, _) >> { 'successful token' }
        successloginServiceStub.hasAuthentication('successful token', 'printReport') >> { true }

        and: 'the report printer is started'
        ReportPrinter printer = new ReportPrinter(successloginServiceStub)
        printer.start('userId', 'password')

        expect: 'to get the report'
        printer.printReport() == 'This is a huge report'
    }

}