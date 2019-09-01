package source.turing.exceptions;

public class TuringCommandParserException extends Exception {
    private String message;

    public TuringCommandParserException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
