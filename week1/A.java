import java.util.Scanner;

/**
 * A
 * https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/A
 */
public class A {

    public static void f(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("I love Recursion");
        f(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
    }
}