package exceptions;

public class BadRequestException extends RuntimeException {
    private String message;
    public BadRequestException(String message){
        super(String.format("This is BadRequestException. Reason is: %s", message));
        this.message = message;
    }
}
