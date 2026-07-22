package week3;

import java.util.Scanner;

public class Cses1637FuerzaBruta {

    public static int solve(int n) {
        if (n == 0) {
            return 0;
        }

        int mejor = Integer.MAX_VALUE;
        int numero = n;
        int digito = 0;
        while (numero > 0) {
            digito = numero % 10;
            numero = numero / 10;

            if (digito != 0) {
                int pasos = 1 + solve(n - digito);
                mejor = Math.min(mejor, pasos);
            }
        }
        return mejor;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
}
