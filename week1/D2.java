import java.util.Scanner;

/**
 * D
 * https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/D
 */
public class D2 {

    public static void f(int n) {
        if (n < 10) {
            System.out.print(n + " ");
            return;
        }
        f(n/10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            f(n);
            System.out.println();
        }
    }
}