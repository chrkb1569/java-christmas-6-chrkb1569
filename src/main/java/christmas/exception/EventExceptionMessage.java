package christmas.exception;

public enum EventExceptionMessage {
    NOT_VALID_FORMAT("[ERROR] 숫자를 입력해주세요."),
    NOT_VALID_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
    ;
    private final String message;

    EventExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
