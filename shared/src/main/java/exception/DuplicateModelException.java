package exception;

public class DuplicateModelException extends RuntimeException {
    public DuplicateModelException(String message) {
        super(message);
    }
}
