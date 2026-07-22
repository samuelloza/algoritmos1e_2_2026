package week3;

public class MinimoMonedasRecursivo {

    public static int minimoMonedas(int n, int[] monedas) {
        if (n == 0) {
            return 0;
        }

        int mejor = Integer.MAX_VALUE;

        for (int i = 0; i < monedas.length; i++) {
            int moneda = monedas[i];

            if (moneda <= n) {
                int resultado = 1 + minimoMonedas(n - moneda, monedas);
                mejor = Math.min(mejor, resultado);
            }
        }

        return mejor;
    }

    public static void main(String[] args) {
        int[] monedas = {1, 3, 4};

        System.out.println(minimoMonedas(10, monedas));
    }
}
