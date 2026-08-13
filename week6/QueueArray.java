package week6;

import java.util.ArrayList;

public class QueueArray {
    public ArrayList<Integer> array;

    public QueueArray() {
        array = new ArrayList<Integer>();
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    public void enqueue(int value) {
        array.add(value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = array.get(0);
        array.remove(0);
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array.get(0);

    }

    public static void main(String[] args) {
        QueueArray queue = new QueueArray();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());//1
        System.out.println(queue.dequeue());//2
        System.out.println(queue.dequeue());//3
        System.out.println(queue.dequeue());//error
        System.out.println(queue.dequeue());//error
        System.out.println(queue.peek());//error






    }

}
