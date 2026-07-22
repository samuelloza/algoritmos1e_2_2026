package week3;

public class t_greedy_mochila_fraccionaria {

    public static int seleccionar(int[] pesos, int[] valores, boolean[] visitados) {
        int mejorIndice = -1;
        double mejorRazon = -1;

        for (int i = 0; i < pesos.length; i++) {
            double razon = valores[i] / (double) pesos[i];

            if (!visitados[i] && razon > mejorRazon) {
                mejorRazon = razon;
                mejorIndice = i;
            }
        }

        return mejorIndice;
    }

    public static double[] greedy(int[] pesos, int[] valores, int capacidad) {
        double[] solucion = new double[pesos.length];
        boolean[] visitados = new boolean[pesos.length];
        double pesoActual = 0;

        while (pesoActual < capacidad) {
            int i = seleccionar(pesos, valores, visitados);

            if (i == -1) {
                break;
            }

            visitados[i] = true;

            if (pesoActual + pesos[i] <= capacidad) {
                solucion[i] = 1;
                pesoActual += pesos[i];
            } else {
                solucion[i] = (capacidad - pesoActual) / pesos[i];
                pesoActual = capacidad;
            }
        }

        return solucion;
    }

    public static void main(String[] args) {
        int[] pesos = { 10, 20, 30, 40, 50 };
        int[] valores = { 20, 30, 66, 40, 60 };
        int capacidad = 100;

        double[] solucion = greedy(pesos, valores, capacidad);
        double pesoTotal = 0;
        double valorTotal = 0;

        for (int i = 0; i < solucion.length; i++) {
            pesoTotal += solucion[i] * pesos[i];
            valorTotal += solucion[i] * valores[i];

            System.out.println("Objeto " + (i + 1) + ": " + (solucion[i] * 100) + "%");
        }

        System.out.println("Peso total = " + pesoTotal);
        System.out.println("Valor total = " + valorTotal);
    }
}
