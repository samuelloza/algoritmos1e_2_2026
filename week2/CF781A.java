import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class CF781A {

    static final int N = 200010;

    static int[] color = new int[N];
    static boolean[] visited = new boolean[N];
    static ArrayList<Integer>[] adj = new ArrayList[N];

    static int totalColors;

    public static void dfs(int node, int currentColor, int parentColor) {

        visited[node] = true;

        Stack<Integer> availableColors = new Stack<>();

        for (int pColor = 1; pColor <= totalColors; pColor++) {

            /*
             * Verificar si se puede utilizar el color pColor
             *
             * El color debe ser diferente al color actual y al padre
             * Si cumple la condicion se agrega
             */

            if (availableColors.size() == adj[node].size()) {
                break;
            }
        }

        //Recorremos todos los nodos del node
        for (int i = 0; i < adj[node].size(); i++) {

            int child = adj[node].get(i);

            if (!visited[child]) {

                /*
                 * Extraer un color disponible de la pila y asignar al child
                 * availableColors.pop()
                 */

                /*
                 * Llamar recursivamente al dfs.
                 */
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        totalColors = 0;

        for (int i = 1; i <= n; i++) {

            int grado = adj[i].size();

            totalColors = Math.max(
                    totalColors,
                    grado + 1);
        }
        //Se asigna el primero color al node raiz
        color[1] = 1;

        dfs(1, color[1], 0);

        System.out.println(totalColors);

        //print de los colores
    }
}