package Week03;

/**
 * Created by Erik on 9/20/2017.
 */
public class BasicPair <T> implements PairInterface{

    protected T [] elements;
    private int maxSize = 10;

    public BasicPair(Object obj1, Object obj2){
        elements = (T[]) new Object[maxSize];
        this.setFirst(obj1);
        this.setSecond(obj2);
    }

    @Override
    public void setFirst(Object item) {
        elements[1] = (T)item;
    }

    @Override
    public void setSecond(Object item) {
        elements[2] = (T)item;
    }

    @Override
    public Object getFirst() {
        return elements[1];
    }

    @Override
    public Object getSecond() {
        return elements[2];
    }
}
