package Types;
import List.MyLinkedList;
import List.MyList;
import java.util.EmptyStackException;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}