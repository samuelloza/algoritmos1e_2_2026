package week7;

import java.util.Scanner;

/**
 * CF847A
 */
public class CF847A {

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            if (left != 0) {
                nodes[i].prev = nodes[left];
            }

            if (right != 0) {
                nodes[i].next = nodes[right];
            }
        }

        Node first = null;
        Node last = null;

        for (int i = 1; i <= n; i++) {
            if (nodes[i].prev == null) {
                if (first == null) {
                    first = nodes[i];
                    last = first;

                    while (last.next != null) {
                        last = last.next;
                    }
                } else {
                    last.next = nodes[i];
                    nodes[i].prev = last;
                    while (last.next != null) {
                        last = last.next;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int left = 0;
            int right = 0;

            if (nodes[i].prev != null) {
                left = (int)nodes[i].prev.data;
            }

            if (nodes[i].next != null) {
                right = (int)nodes[i].next.data;
            }

            System.out.println(left + " " + right);
        }


    }
}