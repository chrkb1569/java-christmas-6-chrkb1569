package christmas.exception;

public class NotValidStatusException extends IllegalStateException {
    public NotValidStatusException(String message, int limit) {
        super(String.format(message, limit));
    }
}
