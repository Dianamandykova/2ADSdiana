
public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");

        MyStack<Integer> myStack = new MyStack<>();

        myStack.push(12);
        myStack.push(15);
        myStack.push(114);
        myStack.push(14);
        myStack.push(112);
        myStack.push(23);
        myStack.pop();

    }
}