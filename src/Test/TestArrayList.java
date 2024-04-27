package Test;

import List.MyArrayList;
import List.MyList;

import java.util.Arrays;

public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> n = new MyArrayList<>();
        testAddMethods(n);
        testGetMethods(n);
    }

    private static void testAddMethods(MyArrayList<Integer> n){
        n.add(1);
        n.addFirst(2);
        n.addLast(3);
        n.add(4, 3);
        n.addLast(5);

        System.out.println("adding " + Arrays.toString(n.toArray()));
    }
    private static void testGetMethods(MyList<Integer> n) {
        for (int i = 1; i <= 5; i++) {
            n.add(i);
        }
        Integer getElement = n.get(0);
        Integer getFirstElement = n.getFirst();
        Integer getLastElement = n.getLast();


        System.out.println("index 3: " + getElement);
        System.out.println("First element: " + getFirstElement);
        System.out.println("Last element: " + getLastElement);
    }


}