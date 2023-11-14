package christmas.exception;

public class NotValidInputException extends IllegalArgumentException {
    public NotValidInputException(final String message) {
        super(message);
    }
}
