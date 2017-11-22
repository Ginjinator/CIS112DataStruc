package Week03;

/**
 * Created by Erik on 9/17/2017.
 */
public interface PairInterface <T> {
    public void setFirst(T item);
    public void setSecond(T item);
    public T getFirst();
    public T getSecond();
}