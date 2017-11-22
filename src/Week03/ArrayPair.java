package Week03;

/**
 * Created by Erik on 9/17/2017.
 */
public class ArrayPair <T> implements PairInterface{

    protected T [] elements;
    private int maxSize = 2;

    public ArrayPair(Object obj1, Object obj2){
        elements = (T[]) new Object[maxSize];
        this.setFirst(obj1);
        this.setSecond(obj2);
    }

    @Override
    public void setFirst(Object item) {
        elements[0] = (T)item;
    }

    @Override
    public void setSecond(Object item) {
        elements[1] = (T)item;
    }

    @Override
    public Object getFirst() {
        return elements[0];
    }

    @Override
    public Object getSecond() {
        return elements[1];
    }
}