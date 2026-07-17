import java.util.Scanner;

public class uva10443 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 1oe creacion del Scanner
        // 1oe asignacion a sc
        // => 2oe

        int t = sc.nextInt();
        // 1oe lectura
        // 1oe asignacion
        // => 2oe

        int r, c, d;

        /*
         * El ciclo exterior se ejecuta t veces, una vez por cada caso de prueba.
         */
        for (int i = 0; i < t; i++) {

            r = sc.nextInt(); // 1oe lectura + 1oe asignacion = 2oe
            c = sc.nextInt(); // 1oe lectura + 1oe asignacion = 2oe
            d = sc.nextInt(); // 1oe lectura + 1oe asignacion = 2oe

            char[][] matrix = new char[r][c];
            // 1oe creacion de la matriz
            // 1oe asignacion
            // => 2oe

            /*
             * Lectura de la matriz.
             *
             * El primer ciclo se ejecuta r veces.
             * Por cada fila, el segundo ciclo se ejecuta c veces.
             *
             *
             * r * c
             *
             * Complejidad
             *
             * O(r * c)
             */
            for (int j = 0; j < r; j++) {

                String line = sc.next();
                // 1oe lectura
                // 1oe asignacion
                // => 2oe

                for (int k = 0; k < c; k++) {

                    matrix[j][k] = line.charAt(k);
                    // 1oe acceso al caracter line.charAt(k)
                    // 1oe asignacion en matrix[j][k]
                    // => 2oe
                }
            }

            /*
             * El primer ciclo se ejecuta d veces
             * Dentro se recorren las r filas
             * Por cada fila se recorren las c columnas
             *
             * Cantidad total de llamadas a win:
             *
             * d * r * c
             *
             * Como win revisa como maximo 4 vecinos, su complejidad es constante
             *
             * win = O(1)
             *
             *
             * O(d * r * c * 1)
             * O(d * r * c)
             */
            for (int j = 0; j < d; j++) {

                char[][] matrix_copy = new char[r][c];
                // 1oe creacion
                // 1oe asignacion
                // Total aproximado: 2oe
                //
                // La creacion de una matriz de r*c posiciones
                // tambien puede considerarse O(r*c).

                for (int k = 0; k < r; k++) {

                    for (int k2 = 0; k2 < c; k2++) {

                        matrix_copy[k][k2] = win(matrix, k, k2, r, c);

                        /*                         *
                         * 1oe acceso a la posicion matrix_copy[k][k2]
                         * 1oe asignacion
                         * 66oe por win
                         *
                         * Total:
                         *
                         * 68oe
                         *
                         * Sin embargo, 68 es una constante:
                         *
                         * O(68) = O(1)
                         */
                    }
                }

                matrix = matrix_copy;
                // 1oe asignacion de referencia
            }

            /*
             * Complejidad de la simulacion:
             *
             * O(d * r * c)
             */

            /*
             * print
             *
             * El ciclo exterior se ejecuta r veces.
             * El ciclo interior se ejecuta c veces.
             *
             * r * c
             *
             * Complejidad:
             *
             * O(r * c)
             */
            for (int j2 = 0; j2 < r; j2++) {

                for (int k = 0; k < c; k++) {

                    System.out.print(matrix[j2][k]);
                    // 1oe acceso a la matriz
                    // 1oe Impresion
                    // Total aproximado: 2oe
                }

                System.out.println(); // 1oe
            }

            /*
             * Se imprime una línea vacia entre casos,
             * excepto después del último.
             */
            if (i < t - 1) {
                // 1oe resta t - 1
                // 1oe comparación
                // => 2oe

                System.out.println(); // 1oe
            }

            /*
             * Complejidad total por caso:
             *
             * Lectura:
             * O(r * c)
             *
             * Simulacion:
             * O(d * r * c)
             *
             * Impresion:
             * O(r * c)
             *
             * Sumando:
             *
             * T(r,c,d) =
             * O(r*c) + O(d*r*c) + O(r*c)
             *
             * T(r,c,d) =
             * O(2*r*c + d*r*c)
             *
             * Factorizando:
             *
             * T(r,c,d) =
             * O(r*c*(d + 2))
             *
             *
             * O(d * r * c)
             */
        }

        /*
         * Complejidad total para t casos:
         *
         * O(t * (r*c + d*r*c + r*c))
         *
         * O(t * r*c*(d + 2))
         *
         *
         * O(t * d * r * c)
         *
         * Esta expresión supone que todos los casos
         * tienen aproximadamente los mismos valores
         * máximos de r, c y d.
         */

        sc.close(); // 1oe
    }

    /*
     * Complejidad temporal:
     *
     * Mejor caso:
     * O(t * r * c)
     *
     * Esto ocurre respecto de d cuando d = 0.
     * Aun así, se debe leer e imprimir toda la matriz.
     *
     * Peor caso:
     * O(t * d * r * c)
     *
     * Complejidad espacial:
     * O(r * c)
     *
     * Se mantienen simultáneamente:
     *
     * matrix      -> r*c posiciones
     * matrix_copy -> r*c posiciones
     *
     * 2*r*c se simplifica a O(r*c).
     */

    // Esta parte se detalla en el documento Word, página 8.
    public static char win(char[][] matrix,
            int i_init, int j_init,
            int r, int c) {

        int[] di = {-1, 1, 0, 0};
        // 1oe creacion y asignacion segun el criterio adoptado

        int[] dj = {0, 0, 1, -1};
        // 1oe creacion y asignacion segun el criterio adoptado

        /*
         * Los arreglos di y dj representan los cuatro movimientos:
         *
         * Arriba:    (-1, 0)
         * Abajo:     ( 1, 0)
         * Derecha:   ( 0, 1)
         * Izquierda: ( 0,-1)
         */

        if (matrix[i_init][j_init] == 'R') {
            // 1oe acceso a matrix[i_init][j_init]
            // 1oe comparación con 'R'
            // => 2oe

            /*
             * En el peor caso, el ciclo revisa los 4 vecinos
             * y ninguno contiene 'P'.
             */
            for (int k = 0; k < 4; k = k + 1) {

                /*
                 * Control del for:
                 *
                 * int k = 0   -> 1oe
                 * k < 4       -> 1oe por evaluación
                 * k = k + 1   -> 1oe suma + 1oe asignacion
                 *               => 2oe
                 */

                int i = i_init + di[k];
                // 1oe acceso a di[k]
                // 1oe suma
                // 1oe asignacion
                // => 3oe

                int j = j_init + dj[k];
                // 1oe acceso a dj[k]
                // 1oe suma
                // 1oe asignacion
                // => 3oe

                if (i >= 0               // 1oe
                        && i < r          // 1oe
                        && j >= 0         // 1oe
                        && j < c          // 1oe
                        && matrix[i][j] == 'P') {
                    // 1oe acceso a matrix[i][j]
                    // 1oe comparación con 'P'
                    //
                    // Total de la condición:
                    // 6oe

                    return 'P'; // 1oe
                }

                /*
                 * Costo del cuerpo cuando la condición es falsa:
                 *
                 * 3oe + 3oe + 6oe
                 *
                 * Total:
                 *
                 * 12oe por iteración
                 */
            }

            /*
             *
             * T(n) =
             * 1oe
             * + 1oe
             * + sumatoria desde k=1 hasta 4
             *   de (12oe + 1oe + 2oe)
             *
             * Donde:
             *
             * 1oe inicial:
             * int k = 0
             *
             * 1oe final:
             * última comparación falsa k < 4
             *
             * 12oe:
             * cuerpo del ciclo
             *
             * 1oe:
             * comparación verdadera k < 4
             *
             * 2oe:
             * actualización k = k + 1
             *
             * T(n) =
             * 1 + 1 + sumatoria de 15oe, cuatro veces
             *
             * T(n) =
             * 2 + 4(15)
             *
             * T(n) =
             * 62oe
             */

            return 'R'; // 1oe

            /*
             * Costo aproximado del caso R:
             *
             * 2oe condición inicial
             * + 62oe ciclo
             * + 1oe return
             *
             * Total:
             *
             * 65oe
             */
        }

        if (matrix[i_init][j_init] == 'S') {
            // 1oe acceso a la matriz
            // 1oe comparación con 'S'
            // => 2oe

            for (int k = 0; k < 4; k = k + 1) {

                int i = i_init + di[k]; // 3oe
                int j = j_init + dj[k]; // 3oe

                if (i >= 0
                        && i < r
                        && j >= 0
                        && j < c
                        && matrix[i][j] == 'R') {
                    // Condición completa: 6oe

                    return 'R'; // 1oe
                }
            }

            return 'S'; // 1oe
        }

        /*
         * Si no es R ni S, entonces la celda contiene P.
         */
        for (int k = 0; k < 4; k = k + 1) {

            int i = i_init + di[k]; // 3oe
            int j = j_init + dj[k]; // 3oe

            if (i >= 0
                    && i < r
                    && j >= 0
                    && j < c
                    && matrix[i][j] == 'S') {
                // Condición completa: 6oe

                return 'S'; // 1oe
            }
        }

        return 'P'; // 1oe
    }
}