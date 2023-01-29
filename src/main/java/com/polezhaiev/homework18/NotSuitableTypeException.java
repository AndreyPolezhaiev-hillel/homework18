package main.java.com.polezhaiev.homework18;

public class NotSuitableTypeException extends Exception {
    public NotSuitableTypeException(String type){
        super("Product [category: " + type + "] isn't found");
    }
}
