package Exceptions;

public class InssuficentStock extends Exception {
    public InssuficentStock(){
        super("Not enough products!");
    }
}
