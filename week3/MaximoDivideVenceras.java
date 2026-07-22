package week3;

public class MaximoDivideVenceras {

    public static int maximo(int[] numeros, int inicio, int fin) {
        if (inicio == fin) {
            return numeros[inicio];
        }

        int medio = (inicio + fin) / 2;

        int maximoIzquierda = maximo(numeros, inicio, medio);
        int maximoDerecha = maximo(numeros, medio + 1, fin);

        return Math.max(maximoIzquierda, maximoDerecha);
    }

    public static void main(String[] args) {
        int[] numeros = {7, 2, 15, 4, 9, 21, 3, 12};

        int respuesta = maximo(numeros, 0, numeros.length - 1);

        System.out.println("El número mayor es: " + respuesta);
    }
}
