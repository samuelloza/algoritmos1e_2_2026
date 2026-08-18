package week6;

import java.util.Scanner;

class ONP<T> {

    public Node<T> top;
    public int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public ONP() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        return top.data;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String line = "";
        while (n-- > 0) {
            line = sc.next();
            StackNode<Character> stack = new StackNode<>();
            for (int i = 0; i < line.length(); i++) {
                char character = line.charAt(i);
                if (character == ')') {
                    System.out.print(stack.pop());
                } else if (character == '+' || character == '-' || character == '*' || character == '/'
                        || character == '^') {
                    stack.push(character);
                } else if (character != '(') {
                    System.out.print(character);
                }
            }
            System.out.println();
        }

    }
}