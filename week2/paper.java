import java.util.Scanner;

public class paper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int r, c, d;
        for (int i = 0; i < t; i++) {
            r = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            sc.nextLine();
            char[][] matrix = new char[r][c];

            for (int j = 0; j < r; j++) {
                String line = sc.next();
                for (int k = 0; k < c; k++) {
                    matrix[j][k] = line.charAt(k);
                }
            }

            char[][] matrix_copy = new char[r][c];
            for (int j = 0; j < d; j++) {
                for (int k = 0; k < r; k++) {
                    for (int k2 = 0; k2 < c; k2++) {
                        matrix_copy[k][k2] = win(matrix, k, k2, r, c);
                    }
                }
            }

            for (int j2 = 0; j2 < r; j2++) {
                for (int k = 0; k < c; k++) {
                    System.out.print(matrix_copy[j2][k]);
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    public static char win(char[][] matrix, int i_init, int j_init, int r, int c) {
        int[] di = { -1, 1, 0, 0 };
        int[] dj = { 0, 0, 1, -1 };
        //Rock
        if (matrix[i_init][j_init] == 'R') {
            for (int k = 0; k < 4; k++) {
                int i = i_init + di[k];
                int j = j_init + dj[k];

                if (i >= 0 && i < r && j >= 0 && j < c && matrix[i][j] == 'P') {
                    return 'P';
                }
            }
            return 'R';
        }

        //Slice
        if (matrix[i_init][j_init] == 'S') {
            for (int k = 0; k < 4; k++) {
                int i = i_init + di[k];
                int j = j_init + dj[k];

                if (i >= 0 && i < r && j >= 0 && j < c && matrix[i][j] == 'R') {
                    return 'R';
                }
            }
            return 'S';
        }

        for (int k = 0; k < 4; k++) {
            int i = i_init + di[k];
            int j = j_init + dj[k];

            if (i >= 0 && i < r && j >= 0 && j < c && matrix[i][j] == 'S') {
                return 'S';
            }
        }
        return 'P';

    }
}
