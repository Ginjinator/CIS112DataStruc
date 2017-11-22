package Week03;

/**
 * Created by Erik on 9/17/2017.
 */

public class StackOverflowException extends RuntimeException
{
    public StackOverflowException()
    {
        super();
    }

    public StackOverflowException(String message)
    {
        super(message);
    }
}