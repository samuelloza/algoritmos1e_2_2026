import java.util.Scanner;

/**
 * B
 * https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/B
 */
public class B {

    public static void f(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        f(n - 1);
        //Codigo
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
    }
}