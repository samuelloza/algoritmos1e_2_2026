package week7;

import java.util.Scanner;

class CF1084C<T> {

    public Node<T> top;
    public int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public CF1084C() {
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
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String line = sc.next();

            CF1084C<Character> stack = new CF1084C<>();
            for (int i = 0; i < line.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(line.charAt(i));
                } else {
                    if (stack.peek() == line.charAt(i)) {
                        stack.pop();
                    } else {
                        stack.push(line.charAt(i));
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}