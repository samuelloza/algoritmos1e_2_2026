package week6;

class StackNode<T> {

    public Node<T> top;
    public int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public StackNode() {
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
        StackNode<String> stack = new StackNode<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // stack.pop(); //Elimina C
        // stack.pop(); //Elimina B

        // stack.push("Z");
        // System.out.println(stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }

    }
}