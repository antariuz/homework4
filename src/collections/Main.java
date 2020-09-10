package collections;


import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1).add(2).add(3).add(4).add(5);
        System.out.println(myArrayList);

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("a").add("b").add("c").add("d");
        System.out.println(myLinkedList);

        MyStack myStack = new MyStack();
        myStack.push(1).push(2).push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack);
    }
}
