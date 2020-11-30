package pl.staudt.kamsoft.currency.exception;

public class BusinessException extends Exception {

    public BusinessException(CodeBook code) {
        super("Application failed with code " + code.code + ", " + code.message);
    }
}
