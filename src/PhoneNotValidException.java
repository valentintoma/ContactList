public class PhoneNotValidException extends Exception {
    public PhoneNotValidException() {
        super ();
    }

    public PhoneNotValidException(String message) {
        super ( message );
    }

    public PhoneNotValidException(String message, Throwable cause) {
        super ( message, cause );
    }

    public PhoneNotValidException(Throwable cause) {
        super ( cause );
    }

    protected PhoneNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super ( message, cause, enableSuppression, writableStackTrace );
    }
}
