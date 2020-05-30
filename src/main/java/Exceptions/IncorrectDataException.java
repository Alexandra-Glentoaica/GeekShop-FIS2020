package Exceptions;

public class IncorrectDataException extends Exception {
    public IncorrectDataException(){
        super("One of the identifying elements is invalid! Please try again!");
    }
}
