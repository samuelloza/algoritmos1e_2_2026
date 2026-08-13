package week6;

import java.util.ArrayList;

class StackArray {

    public ArrayList<Integer> array;
    public StackArray() {
        array = new ArrayList<>();
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    public void push(int value) {
        array.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stck is empty");
        }
        int stackSize = array.size();
        int element = array.get(stackSize - 1);
        array.remove(stackSize - 1);
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stck is empty");
        }
        int stackSize = array.size();
        int element = array.get(stackSize - 1);
        return element;
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }


    }
}