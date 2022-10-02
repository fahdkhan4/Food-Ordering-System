package exceptions;

public class ContentNotFound extends RuntimeException{
    public ContentNotFound(String message) {
        super(message);
    }
}
