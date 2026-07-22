package week3;

public class t_greedy_mochila_mayor_valor {
    public static void main(String[] args) {
        int[] w = {10, 20, 30, 40, 50};
        int[] v = {20, 30, 66, 40, 60};

        int capacidad = 100;
        boolean[] solution = greedy(w, v, capacidad);

        for (int i = 0; i < solution.length; i++) {
            if (solution[i]) {
                System.out.print(w[i] + "/" + v[i] + " ");
            }
        }

        System.out.println();
    }

    private static boolean[] greedy(int[] w, int[] v, int capacidad) {
        boolean[] solutions = new boolean[w.length];
        boolean[] visited = new boolean[w.length];

        int currentWeight = 0;

        while (currentWeight < capacidad) {
            int index = select(v, visited);

            if (index == -1) {
                break;
            }

            visited[index] = true;

            if (currentWeight + w[index] <= capacidad) {
                currentWeight = currentWeight + w[index];
                solutions[index] = true;
            }
        }

        return solutions;
    }

    /*
     * Retorna el índice del mayor valor.
     */
    private static int select(int[] v, boolean[] visited) {
        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < visited.length; i++) {
            if (v[i] > max && visited[i] == false) {
                max = v[i];
                index = i;
            }
        }

        return index;
    }
}