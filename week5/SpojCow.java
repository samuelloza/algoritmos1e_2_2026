package week5;

import java.util.Scanner;

public class SpojCow {

    public static boolean isPossible(int vec[], int dist, int vacas) {
        int count = 1;
        int pos = vec[0];

        for (int i = 1; i < vec.length; i++) {
            if (vec[i] - pos >= dist) {
                pos = vec[i];
                count++;
            }

            if (count == vacas) {
                return true;
            }
        }
        return false;
    }

    public static int binarySearch(int vec[], int vacas) {
        int low = 1;
        int high = vec[vec.length - 1] - vec[0];
        int mid = -1;
        int ans = -1;
        while (low <= high) {
            mid = (low + high) / 2; // distancia

            //System.out.println("distancia " + mid + " low " + low + " high" + high);
            if (isPossible(vec, mid, vacas)) {
                low = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                high = mid - 1;
            }
        }
        // No existe
        return ans;
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int leftArray[] = new int[leftSize];
        int rightArray[] = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;

        int currentPosition = left;

        // Compara los elementos de las dos mitades
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[currentPosition] = leftArray[i];
                i++;
            } else {
                arr[currentPosition] = rightArray[j];
                j++;
            }
            currentPosition++;
        }

        // Copia los elemntos de left
        while (i < leftSize) {
            arr[currentPosition] = leftArray[i];
            i++;
            currentPosition++;
        }

        // Copia los elemntos de right
        while (j < rightSize) {
            arr[currentPosition] = rightArray[j];
            j++;
            currentPosition++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) { // 1 < 1
            int mid = left + (right - left) / 2;
            // Recorre la parte izquierda
            // inicia en 0 hasta el mid
            mergeSort(arr, left, mid);

            // inicia en mid + 1 hasta el right
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, c;

        while (t-- > 0) {
            n = sc.nextInt();
            c = sc.nextInt();
            int vec[] = new int[n];
            for (int i = 0; i < n; i++) {
                vec[i] = sc.nextInt();
            }
            /*
             * System.out.println("Vacas " + c);
             * for (int i = 0; i < vec.length; i++) {
             * System.out.print(vec[i] + " ");
             * }
             */

            mergeSort(vec, 0, vec.length - 1);

            // System.out.println();
            int ans = binarySearch(vec, c);
            System.out.println(ans);
        }

    }
}
