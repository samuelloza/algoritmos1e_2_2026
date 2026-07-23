package week3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codeforces.com/contest/2245/problem/B
 */
public class 2245 {

    public static long greedy(long[] a, long c) {
        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            a[i] -= c;
        }

        for (int i = 0; i < a.length / 2; i++) {
            if (a[i] < 0) {
                a[i] = 0;
            }
        }

        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long c = sc.nextLong();
            long vec[] = new long[n];
            for (int i = 0; i < vec.length; i++) {
                vec[i] = sc.nextInt();
            }
            System.out.println(greedy(vec, c));

        }
    }
}