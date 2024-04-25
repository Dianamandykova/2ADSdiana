package Lists;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private static final int DEFAULT = 5;
    private T[] array;
    private int size;

    public MyArrayList(){
        array = (T[]) new Object[DEFAULT];
        size = 0;
    }
    @Override
    public void add(T item){
        if (size >= array.length)
            increaseSize();
        array[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        array[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if (size >= array.length) {
            increaseSize();
        }
        checkIndex(index);
        array[index] = item;
    }

    @Override
    public void addFirst(T item) {
        if (size >= array.length)
            increaseSize();
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = item;
        size++;
    }

    @Override
    public void addLast(T item){
        add(item);
    }

    @Override
    public T get(int index){
        checkIndex(index);
        return array[index];
    }
    @Override
    public T getFirst(){
        return array[0];
    }
    @Override
    public T getLast(){
        return array[size - 1];
    }

    @Override
    public void remove(int index){
        checkIndex(index);
        for(int i = index + 1; i < size; i++){
            array[i - 1] = array[i];
        }
        size--;
    }

    @Override
    public void removeFirst(){
        remove(0);
    }

    @Override
    public void removeLast(){
        remove(size - 1);
    }
    @Override
    public int indexOf(T item){
        for (int i = 0; i < size; i++){
            if (item.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(T item){
        for (int i = size - 1; i >= 0; i--){
            if (item.equals(array[i])){
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean exists(T item){
        return indexOf(item) >= 0;

    }
    @Override
    public T[] toArray(){
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++){
            arr[i] = array[i];
        }
        return arr;
    }
    @Override
    public void clear(){
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
    }
    @Override
    public int size(){
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Index invalid");
    }

    private void increaseSize() {
        int newSize = (array.length == 0) ? DEFAULT : array.length * 2;
        T[] newArr = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArr, 1, size);
        array = newArr;
    }

    @Override
    public Iterator<T> iterator(){
        return new MyArrayListIterator();
    }
    private class MyArrayListIterator implements Iterator<T>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext(){
            return currentIndex < size;
        }
        @Override
        public T next(){
            if (!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return array[currentIndex++];
        }
        @Override
        public void remove(){
            throw new UnsupportedOperationException("is not supported");
        }
    }
}