package christmas.exception;

public class NotValidInputException extends IllegalArgumentException {
    public NotValidInputException(String message) {
        super(message);
    }
}
