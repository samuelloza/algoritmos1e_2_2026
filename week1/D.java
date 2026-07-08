import java.util.Scanner;

/**
 * D
 * https://codeforces.com/group/MWSDmqGsZm/contest/223339/problem/D
 */
public class D {

    public static void f(String cad, int index) {
        if (index < 0) {
            return;
        }

        f(cad, index - 1);
        System.out.print(cad.charAt(index));
        if (index < cad.length() - 1) {
            System.out.print("_");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String cad = n + "";
            int index = cad.length() - 1;
            f(cad, index);
            System.out.println();
        }
    }
}