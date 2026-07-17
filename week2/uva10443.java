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
                        /*
                         * win(...) = 71oe
                         *
                         * Segun el criterio usado en la tabla,
                         * el costo adoptado para esta instruccion
                         * es 71oe.
                         *
                         * Como 71 es constante:
                         *
                         * O(71) = O(1)
                         */
                    }
                }

                matrix = matrix_copy;
                // 1oe asignacion de referencia
            }
            /*
             * Costo del ciclo de columnas:
             *
             * 1 + c(1 + 71 + 2) + 1
             * = 74c + 2
             *
             * Costo del ciclo de filas:
             *
             * 1 + r(1 + (71c + 2) + 2) + 1
             * = 71rc + 5r + 2
             *
             * Costo de un dia:
             *
             * 2 + (71rc + 5r + 2) + 1
             * = 71rc + 5r + 5
             *
             * Costo de los d dias:
             *
             * 1 + d(1 + 71rc + 5r + 5 + 2) + 1
             * = 71drc + 5dr + 8d + 2
             *
             * Complejidad:
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
             * Costo total por caso:
             *
             * T(caso) = Tinicial + Tlectura + Tdias + Tsalida
             *
             * T(caso) =
             * 8
             * + (5rc + 7r + 2)
             * + (71drc + 5dr + 8d + 2)
             * + (5rc + 6r + 2)
             *
             * T(caso) =
             * 71drc + 10rc + 5dr + 13r + 8d + 14
             *
             * El termino dominante es:
             *
             * 71drc
             *
             * Por tanto:
             *
             * O(d * r * c)
             */
        }
        /*
         * Costo total para t casos:
         *
         * 2 + 1 + t(1 + Tcaso + 2) + 1
         *
         * = 4 + t(Tcaso + 3)
         *
         * Por tanto:
         *
         * O(t * d * r * c)
         *
         * Esta expresion supone que todos los casos
         * tienen aproximadamente los mismos valores
         * de r, c y d.
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
                 * Costo del cuerpo cuando la condicion es falsa:
                 *
                 * 3oe + 3oe + 6oe
                 *
                 * Total:
                 *
                 * 12oe por iteracion
                 *
                 * Si la condicion es verdadera:
                 *
                 * 12oe + 1oe del return
                 *
                 * Total:
                 *
                 * 13oe por iteracion
                 *
                 * Para el calculo adoptado en la tabla
                 * se usa 13oe como costo del cuerpo.
                 */
            }
            /*
             * T(for) =
             *
             * 1oe + sumatoria desde k=1 hasta 4
             * de (13oe + 1oe + 2oe) + 1oe
             *
             * Donde:
             *
             * 1oe:
             * inicializacion int k = 0
             *
             * 13oe:
             * cuerpo del ciclo
             *
             * 1oe:
             * comparacion verdadera k < 4
             *
             * 2oe:
             * incremento k = k + 1
             *
             * 1oe:
             * comparacion final falsa k < 4
             *
             * T(for) =
             * 1 + 4(16) + 1
             *
             * T(for) =
             * 66oe
             */

            return 'R'; // 1oe
            /*
             * Costo del caso R:
             *
             * 2oe condicion inicial
             * + 66oe ciclo completo
             * + 1oe return
             *
             * Total:
             *
             * 69oe
             *
             * Los arreglos di y dj se suman despues
             * al calcular el costo total de win.
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

        /*
         * Costo total del metodo win:
         *
         * T(win) = 1oe + 1oe + max(TR, TS, TP)
         *
         * T(win) = 1 + 1 + 69
         *
         * T(win) = 71oe
         *
         * Aplicando Big O:
         *
         * O(71) = O(1)
         *
         * La complejidad es constante porque
         * se revisan como maximo cuatro vecinos.
         */
    }
}