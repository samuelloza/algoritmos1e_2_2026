package week4;

public class mergueSort {

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

        //Compara los elementos de las dos mitades
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

        //Copia los elemntos de left
        while (i < leftSize) {
            arr[currentPosition] = leftArray[i];
            i++;
            currentPosition++;
        }

        //Copia los elemntos de right
        while (j < rightSize) {
            arr[currentPosition] = rightArray[j];
            j++;
            currentPosition++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //Recorre la parte izquierda
            // inicia en 0 hasta el mid
            mergeSort(arr, left, mid);
            
            // inicia en mid + 1  hasta el right
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
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
        System.out.println("--------------");
        mergeSort(arrInt, 0, arrInt.length - 1);
        printArray(arrInt);
    }
}
