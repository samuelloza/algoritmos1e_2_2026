package week5;

import java.util.Scanner;

public class LightOJ1088 {

    public static int LowerBound(int vec[], int target) {
        int low = 0;
        int high = vec.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (vec[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int UpperBound(int vec[], int target) {
        int low = 0;
        int high = vec.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (vec[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int caso = 1; caso <= t; caso++) {
            int n = sc.nextInt();
            int q = sc.nextInt();

            int vec[] = new int[n];

            for (int i = 0; i < vec.length; i++) {
                vec[i] = sc.nextInt();
            }

            System.out.println("Case " + caso + ":");

            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                int lower = LowerBound(vec, a);
                int upper = UpperBound(vec, b);

                System.out.println(upper - lower);
            }
        }
    }
}