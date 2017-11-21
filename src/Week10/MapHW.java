package Week10;

import ch08.maps.MapEntry;
import ch08.maps.MapInterface;
import java.util.Iterator;

public class MapHW<K, V> implements MapInterface<K, V>{
    protected MapEntry<K, V>[] map;
    protected int lastIndex = -1;
    protected int maxSize;

    public MapHW(int capacity){
        map = new MapEntry[capacity];
        maxSize = capacity - 1;
        lastIndex = 0;
    }

    @Override
    public V put(K k, V v) {
        if(k == null){
            throw new IllegalArgumentException("Maps do not allow null keys");
        }
        int currentIndex = 0;
        MapEntry<K, V> entry = new MapEntry<>(k, v);
        MapEntry<K, V> temp;

        Iterator<MapEntry<K, V>> find = iterator();

        while (find.hasNext()){
            temp = find.next();
            try{
                if(temp.getKey().equals(k)){
                    map[currentIndex] = entry;
                    return temp.getValue();
                }
            }
            catch (Exception e){

            }
            currentIndex++;
        }
        map[currentIndex] = entry;
        lastIndex++;
        return null;
    }

    @Override
    public V get(K k) {
        if (k == null){
            throw new IllegalArgumentException("Maps do not allow null keys.");
        }
        MapEntry<K, V> temp;
        Iterator<MapEntry<K, V>> find = iterator();

        while (find.hasNext()){
            temp = find.next();
            try{
                if(temp.getKey().equals(k)){
                    return temp.getValue();
                }
            }
            catch (Exception e){

            }
        }
        return null;
    }

    @Override
    public V remove(K k) {
        if (k == null){
            throw new IllegalArgumentException("Maps do not allow null keys.");
        }
        MapEntry<K, V> temp;
        Iterator<MapEntry<K, V>> find = iterator();

        while (find.hasNext()){
            temp = find.next();
            try{
                if(temp.getKey().equals(k)){
                    find.remove();
                    return temp.getValue();
                }
            }
            catch (Exception e){

            }
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        if (k == null){
            throw new IllegalArgumentException("Maps do not allow null keys.");
        }
        MapEntry<K, V> temp;
        Iterator<MapEntry<K, V>> find = iterator();

        while (find.hasNext()){
            temp = find.next();
            try{
                if(temp.getKey().equals(k)){
                    return true;
                }
            }
            catch (Exception e){

            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public boolean isFull() {
        return (lastIndex == (maxSize));
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return new Iterator() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return (currentIndex <= lastIndex);
            }

            @Override
            public MapEntry<K, V> next() {
                return map[currentIndex++];
            }

            @Override
            public void remove() {
                lastIndex--;
                map[currentIndex-1] = new MapEntry<>(null, null);
            }
        };
    }
}