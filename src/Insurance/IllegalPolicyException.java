package Insurance;

/**
 * An Exception class for using with insurance Policy classes
 * @author Ashley Moore
 */
public class IllegalPolicyException extends Exception{
    /**
    * Creates an IllegalPolicyException with a given message
    */
    public IllegalPolicyException(String message){
        super(message);
    }
}