ipackage Lists;

import java.util.Arrays;

public class MyArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;

    public MyArrayList() {
        this.array = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void addFirst(T element) {
        ensureCapacity();
        System.arraycopy(array, 0, array, 1, size);
        array[0] = element;
        size++;
    }

    public void addLast(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void add(T element, int index) {
        ensureCapacity();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) array[0];
    }

    @SuppressWarnings("unchecked")
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return (T) array[size - 1];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
