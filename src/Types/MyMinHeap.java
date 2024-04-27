package Types;
import List.MyArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        bubbleUp(heap.size() - 1);
    }
    public T deleteMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            bubbleDown(0);
        }
        return min;
    }

    public T findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void bubbleUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            heap.swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }


    private void bubbleDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestChildIndex = index;
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
            smallestChildIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestChildIndex)) < 0) {
            smallestChildIndex = rightChildIndex;
        }
        if (smallestChildIndex != index) {
            heap.swap(index, smallestChildIndex);
            bubbleDown(smallestChildIndex);
        }
    }
}