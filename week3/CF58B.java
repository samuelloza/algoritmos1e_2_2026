//CF58B
package week3;
/**
 * https://codeforces.com/problemset/problem/58/B
 */
public class CF58B {

    public static int select(int n) {
        for (int i = 2; i *i <= n; i++) {
            if (n % i == 0) {
                return n / i;
            }
        }
        return 0;
    }

    public static void greedy(int n){
        while (n > 0) {
            System.out.println(n);
            n = select(n);
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        greedy(4);
    }
}