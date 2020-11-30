package pl.staudt.kamsoft.currency.exception;

public enum CodeBook {

    EXTERNAL_CALL_FAILURE("9999", "External call failed");

    String code;
    String message;

    CodeBook(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
