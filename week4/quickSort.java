package week4;

public class quickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotPosition = partition(arr, left, right);
            quickSort(arr, left, pivotPosition - 1);
            quickSort(arr, pivotPosition + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= right && arr[i] <= pivot) {
                i++;
            }
            while (j > left && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arrInt[] = { 4, 5, 8, 7, 9, 1, 2, 100, -1, 0 };
        printArray(arrInt);
        quickSort(arrInt, 0, arrInt.length - 1);
        printArray(arrInt);
    }
}
