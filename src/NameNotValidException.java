public class NameNotValidException extends  Exception {

    public NameNotValidException() {
        super ();
    }

    public NameNotValidException(String message) {
        super ( message );
    }

    public NameNotValidException(String message, Throwable cause) {
        super ( message, cause );
    }

    public NameNotValidException(Throwable cause) {
        super ( cause );
    }

    protected NameNotValidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super ( message, cause, enableSuppression, writableStackTrace );
    }
}
