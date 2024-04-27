package List;

import java.util.Iterator;

public class MyLinkedList<T extends Object & Comparable<T>> implements MyList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        size++;
        Node<T> newNode = new Node<>(item);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    @Override
    public void add(int index, T item) {
        if (head == null || index == size) {
            add(item);
            return;
        }
        checkIndex(index);

        size++;
        Node<T> node = getNodeAt(index + 1);

        Node<T> newNode = new Node<>(item, node.prev, node);
        if (node.prev != null)
            node.prev.next = newNode;
        node.prev = newNode;
        if (newNode.prev == null)
            head = newNode;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public void set(int index, T item) {
        Node<T> node = head;
        while (index-- != 0 && node.next != null)
            node = node.next;
        node.item = item;
    }

    @Override
    public T get(int index) {
        return getNodeAt(index + 1).item;
    }

    @Override
    public T getFirst() {
        return head.item;
    }

    @Override
    public T getLast() {
        return tail.item;
    }

    @Override
    public T remove(int index) {
        if (index == 0) {
            removeFirst();
            return null;
        }
        Node<T> node = getNodeAt(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return null;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        size--;
    }

    @Override
    public void removeLast() {
        tail = tail.prev;
        size--;
    }

    @Override
    public void sort() {
        boolean swapped;
        Node<T> node;

        if (head == null)
            return;

        do {
            swapped = false;
            node = head;

            while (node.next != null) {
                if (node.item.compareTo(node.next.item) > 0) {
                    T t = node.next.item;
                    node.next.item = node.item;
                    node.item = t;
                    swapped = true;
                }
                node = node.next;
            }
        } while (swapped);
    }

    @Override
    public int indexOf(T item) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(item))
                return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        Node<T> node = tail;
        int t = -1;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(item))
                t = i;
            node = node.prev;
        }
        return t;
    }

    @Override
    public boolean exists(T item) {
        return indexOf(item) != -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        T[] array = (T[]) new Comparable[size];
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.item;
            node = node.next;
        }
        return array;
    }


    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> h = head;
        while (h != null) {
            str.append(h.item).append(" ");
            h = h.next;
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    public boolean isEmpty() {
        return size == 0;
    }



    private class Itr implements Iterator<T> {
        Node<T> front;

        public Itr() {
            front = head;
        }

        @Override
        public boolean hasNext() {
            return front != null;
        }

        @Override
        public T next() {
            Node<T> node = front;
            front = front.next;
            return node.item;
        }
    }

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        public Node(T item) {
            this.item = item;
            prev = null;
            next = null;
        }

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> getNodeAt(int index) {
        checkIndex(index);
        Node<T> node = head;
        while (--index != 0 && node.next != null)
            node = node.next;
        return node;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index must be between 0 and " + size);
    }
}