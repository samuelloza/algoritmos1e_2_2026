package week6;

import java.util.Scanner;

public class Cf450A<T> {
    public Node<T> first;
    public Node<T> last;
    public int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private static class Child {
        int index;
        int candies;

        public Child(int index, int candies) {
            this.candies = candies;
            this.index = index;
        }
    }

    public Cf450A() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }

        T data = first.data;
        first = first.next;

        size--;

        if (isEmpty()) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        }
        return first.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Cf450A<Child> queue = new Cf450A<>();
        for (int i = 0; i < n; i++) {
            int candies = sc.nextInt();
            queue.enqueue(new Child(i + 1, candies));
        }

        int answer = -1;
        while (!queue.isEmpty()) {
            Child child = queue.dequeue();
            child.candies = child.candies - m;

            if (child.candies > 0) {
                queue.enqueue(child);
            } else {
                answer = child.index;
            }
        }

        System.out.println(answer);

    }
}
