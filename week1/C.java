import java.util.Scanner;

/**
 * C
 * https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/C
 */
public class C {

    public static void f(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n);
        if (n > 1) {
            System.out.print(" ");
        }
        f(n - 1);
        //Codigo
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f(n);
        System.out.println();
    }
}