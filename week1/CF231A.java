import java.util.Scanner;

public class CF231A {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int p, v, t;
        int sol = 0;
        for (int i = 0; i < n; i++) {
            p = sc.nextInt();
            v = sc.nextInt();
            t = sc.nextInt();

            if (p + v + t >= 2) {
                sol++;
            }
        }
        System.out.println(sol);


    }
}
