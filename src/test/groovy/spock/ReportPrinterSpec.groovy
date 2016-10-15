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

    def 'bad login'() {
        given: 'the login service will fail'
        LoginService failedLoginServiceStub = Stub(LoginService)
        failedLoginServiceStub.login(_, _) >> { null }

        when: 'the report printer is started'
        ReportPrinter printer = new ReportPrinter(failedLoginServiceStub)
        printer.start('userId', 'password')

        then: 'an exception occurs'
        def e = thrown(RuntimeException)
        e.message == "You are not logged in"
    }

    def 'user logins but has no print report authority'() {
        given: 'the login service will succeed but the user has no print authority'
        LoginService loginService = Mock(LoginService)
        1 * loginService.login(_, _) >> { 'successful token' }
        1 * loginService.hasAuthentication('successful token', 'printReport') >> { false }

        and: 'the report printer is started'
        ReportPrinter printer = new ReportPrinter(loginService)
        printer.start('userId', 'password')

        when: 'printing the report'
        printer.printReport()

        then: 'a runtime exception is thrown'
        def e = thrown(RuntimeException)
        e.message == "You are not allowed to use the print print report"
    }

}
