package week3;

import java.util.Scanner;

public class Cses1637Greedy {

    public static int mayor(int n) {
        int numero = n;
        int digito = 0;
        int maxi = -1;
        while (numero > 0) {
            digito = numero % 10;
            numero = numero / 10;
            maxi = Math.max(maxi, digito);
        }
        return maxi;
    }

    public static int solve(int n) {
        int numero = n;
        int digito;
        int count = 0;
        while (numero > 0) {
            digito = mayor(numero);
            numero = numero - digito;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));

    }
}
