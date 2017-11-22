package Week03;

/**
 * Created by Erik on 9/17/2017.
 */

public class StackUnderflowException extends RuntimeException
{
    public StackUnderflowException()
    {
        super();
    }

    public StackUnderflowException(String message)
    {
        super(message);
    }
}