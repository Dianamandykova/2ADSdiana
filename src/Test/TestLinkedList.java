package Test;

import List.MyLinkedList;

public class TestLinkedList{
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.addLast(40);

        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        list.set(2, 25);
        System.out.println("Element at index 2 after setting: " + list.get(2));

        list.remove(3);
        list.removeFirst();
        list.removeLast();
        System.out.println("Size of the list after removals: " + list.size());

        list.add(15);
        list.sort();
        System.out.println("Sorted list: " + list);

        list.add(10);
        list.add(10);
        list.add(15);
        System.out.println("Index of 10: " + list.indexOf(10));
        System.out.println("Last index of 10: " + list.lastIndexOf(10));

        System.out.println("Exists 20? " + list.exists(20));
        System.out.println("Exists 25? " + list.exists(25));

        System.out.println();
    }
}
