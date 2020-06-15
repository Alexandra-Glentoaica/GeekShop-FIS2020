package Exceptions;


public class ProductAlreadyExists extends Exception {
    public ProductAlreadyExists(){
        super("This product already exists!");
    }
}
