package simplejava;

public class FailedLoginException extends RuntimeException {
    public FailedLoginException(String s) {
        super(s);
    }
}
