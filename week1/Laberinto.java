public class Laberinto {

    public static void printMapa(String[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String[][] pintar(String[][] mapa, int i, int j, String camino_libre, String relleno) {
        // Caso base
        if ((i < 0 || j < 0) || (i >= mapa.length || j >= mapa.length)) {
            return mapa;
        }

        if (mapa[i][j].equals(camino_libre) == false) {
            return mapa;
        }
        // Pintar mapa
        mapa[i][j] = relleno;

        int i_pos[] = { -1, 1, 0, 0 };
        int j_pos[] = { 0, 0, 1, -1 };

        // k = 0 //Arriba
        // k = 1 //Abajo
        // k = 2 //Derecha
        // k = 3 //Izquierda
        for (int k = 0; k < j_pos.length; k++) {
            int ii_new = i + i_pos[k];
            int jj_new = j + j_pos[k];
            pintar(mapa, ii_new, jj_new, camino_libre, relleno);
        }
        return mapa;

    }

    public static void main(String[] args) {
        String[][] mapa = {
                { ".", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#" },
                { ".", ".", ".", ".", "#", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "#" },
                { "#", ".", "#", ".", "#", ".", "#", "#", "#", ".", "#", ".", "#", "#", "#", ".", "#", ".", ".", "#" },
                { "#", ".", "#", ".", ".", ".", ".", "#", ".", ".", ".", ".", "#", ".", ".", ".", "#", ".", ".", "#" },
                { "#", "#", "#", "#", "#", "#", ".", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", ".", "#", "#" },
                { "#", ".", ".", ".", ".", ".", ".", "#", ".", ".", ".", ".", ".", ".", ".", ".", "#", ".", ".", "#" },
                { "#", "#", "#", "#", "#", "#", ".", "#", "#", "#", "#", "#", ".", "#", "#", "#", "#", ".", ".", "#" },
                { "#", ".", ".", ".", "#", ".", ".", ".", ".", ".", ".", "#", ".", ".", ".", ".", ".", ".", ".", "#" },
                { "#", "#", "#", ".", "#", "#", "#", "#", ".", ".", "#", "#", "#", "#", "#", "#", ".", "#", "#", "#" },
                { "#", "#", "#", "#", "#", "#", "#", "E", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#",
                        "#" } };

        printMapa(mapa); 
        String mapa2[][] = pintar(mapa, 0, 0, ".", "R");
        printMapa(mapa2);
        

    }
}
